package org.sid.sec;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private DataSource dataSource;

	// Cette methode permet d'indiquer ou se trouve l'utilisateurs qui vont
	// s'authentifier
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// FOR specify where are users?

		BCryptPasswordEncoder bcpe = getBCPE();
		System.out.println(bcpe.encode("1234"));

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select username as principal,password as credentials, active from users where username=?")
				.authoritiesByUsernameQuery(
						"select username as principal,role as role from users_roles users where username=?")
				.rolePrefix("ROLE_").passwordEncoder(getBCPE());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Indiquer au spring security d'utiliser un formulaire d'authentification
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/user/*").hasRole("USER");
		http.exceptionHandling().accessDeniedPage("/403");
	}

	@Bean
	BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();

	}
}

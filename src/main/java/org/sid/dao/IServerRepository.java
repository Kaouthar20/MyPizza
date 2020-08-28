package org.sid.dao;

import org.sid.entities.Server;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IServerRepository extends JpaRepository<Server, Long>{
Page <Server> findBylastNameContains(String kw,Pageable pageable);

@Query("select s from Server s where s.id = :x") 
public Server findByidentif(@Param("x") Long id);
}

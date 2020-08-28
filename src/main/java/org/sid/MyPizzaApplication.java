package org.sid;

/*import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.sid.dao.IBillRepository;
import org.sid.dao.ICustomerRepository;
import org.sid.dao.IDeliveryManReporsitory;
import org.sid.dao.IIngrediantRepository;
import org.sid.dao.IOrderRepository;
import org.sid.dao.IPizzaRepository;
import org.sid.dao.IServerRepository;
import org.sid.entities.Bill;
import org.sid.entities.Customer;
import org.sid.entities.DeliveryMan;
import org.sid.entities.Ingrediant;
import org.sid.entities.Orders;
import org.sid.entities.Pizza;
import org.sid.entities.Server;
import org.sid.mitier.IMetierMyPizza;*/
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class MyPizzaApplication implements CommandLineRunner {
	/*
	 * @Autowired private IDeliveryManReporsitory iDeliveryManRepository;
	 * 
	 * @Autowired private IServerRepository iServerRepository;
	 * 
	 * @Autowired private ICustomerRepository iCustomerRepository;
	 * 
	 * @Autowired private IBillRepository iBilRepository;
	 * 
	 * @Autowired private IIngrediantRepository iIngrediantRepository;
	 * 
	 * @Autowired private IOrderRepository iOrderRepository;
	 * 
	 * @Autowired private IPizzaRepository iPizzaRepository;
	 */
	public static void main(String[] args) {
		SpringApplication.run(MyPizzaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * List<Orders> listOrders = new ArrayList<Orders>();
		 * 
		 * Bill b1=iBilRepository.save(new Bill(50)); Server
		 * s1=iServerRepository.save(new Server("Adam", "Vall",
		 * "2126887755",listOrders)); Server s2=iServerRepository.save(new
		 * Server("Sami", "Brain", "2126887755",listOrders)); Server
		 * s3=iServerRepository.save(new Server("Salma", "Noury",
		 * "2126867752",listOrders)); Server s4=iServerRepository.save(new
		 * Server("Ilham", "youssfi", "2126867733",listOrders)); Server
		 * s5=iServerRepository.save(new Server("Yassine", "assif",
		 * "2126867733",listOrders)); DeliveryMan dm2=iDeliveryManRepository.save(new
		 * DeliveryMan("Yasser", "Najjar", "2126999000",listOrders)); DeliveryMan
		 * dm3=iDeliveryManRepository.save(new DeliveryMan("Karim", "Yazidi",
		 * "2126999005",listOrders)); Customer c1=iCustomerRepository.save(new
		 * Customer("Ali", "Nadir", "25 Street HASSAN-RABAT", "ali@gmail.com",
		 * "2126550033")); Customer c2=iCustomerRepository.save(new Customer("Alaa",
		 * "Noa", "25 Street HASSAN-RABAT", "alaa@gmail.com", "2126550033"));
		 * 
		 * Ingrediant ingrediant1 = iIngrediantRepository.save(new
		 * Ingrediant("Olive oil\n" + "Salt\n" + " Balsic\n" + " tomato Sauce"));
		 * List<Ingrediant> listeingridiants1 = new ArrayList<Ingrediant>();
		 * listeingridiants1.add(ingrediant1); Ingrediant ingrediant2 =
		 * iIngrediantRepository.save(new Ingrediant("tomato\n" + "  ham\n" +
		 * "  Mozzarella\n" + "  grated cheese")); List<Ingrediant> listeingridiants2 =
		 * new ArrayList<Ingrediant>(); listeingridiants2.add(ingrediant2); Pizza
		 * p1=iPizzaRepository.save(new Pizza("Margherita", 35.00,
		 * 2,listeingridiants1)); iPizzaRepository.save(new Pizza("Royal", 45.00,
		 * 2,listeingridiants1));
		 * 
		 * iPizzaRepository.save(new Pizza("Milano", 40.00, 1,listeingridiants1));
		 * iPizzaRepository.save(new Pizza("Vegetarienne", 45.00, 1,listeingridiants2));
		 * iPizzaRepository.save(new Pizza("Seafood", 50.00, 1,listeingridiants2));
		 * 
		 * //Orders order1=iOrderRepository.save(new Orders(new Date(), "valide",p1, s1,
		 * dm2, c1, b1)); iPizzaRepository.findAll().forEach(p->{
		 * 
		 * System.out.println(p.toString()); });
		 * System.out.println("**************************************"); Page<Pizza>
		 * pizzas=iPizzaRepository.search("%M%", PageRequest.of(0, 2));
		 * System.out.println(pizzas.getSize());
		 * System.out.println(pizzas.getTotalElements());
		 * System.out.println(pizzas.getTotalPages()); pizzas.getContent().forEach(p->{
		 * 
		 * System.out.println(p.toString()); }); //iMetierMyPizza.searchPizzaById(11L);
		 */

		// iServerRepository.findAll().forEach(s->{
		// System.out.println(s.getFirstName());});
		// iDeliveryManRepository.findAll().forEach(d->{
		// System.out.println(d.getFirstName());});*/
	}

}

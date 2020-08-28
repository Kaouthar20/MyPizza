/*package org.sid.mitier;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.sid.dao.IPizzaRepository;
import org.sid.entities.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IMetierMyPizzaImp implements IMetierMyPizza{
	@Autowired
	private  IPizzaRepository  iPizzaRepository; 
	
	@Override
	public List<Pizza> getAllPizza() {
		
		return iPizzaRepository.findAll();
	}

	@Override
	public void addPizza(Pizza p) {
		iPizzaRepository.save(p);
		
	}

	@Override
	public void deletePizza(Long id) {
		iPizzaRepository.deleteById(id);
		
	}

	@Override
	public Pizza searchPizzaById(Long id) {
		Optional <Pizza> pizza=iPizzaRepository.findById(id);  
		return pizza.orElse(null);
	}

	




	

}*/
  
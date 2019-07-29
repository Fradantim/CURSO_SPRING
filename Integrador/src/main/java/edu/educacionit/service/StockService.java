package edu.educacionit.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.github.javafaker.Pokemon;

import edu.educacionit.model.Stock;
import edu.educacionit.repository.StockRepository;

@Service
public class StockService {

	private final static Faker FAKER = new Faker();
	
	@Autowired
	private StockRepository stockRepo;
	
	public Stock findById(Long id) {
		try {
			return stockRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	public Stock save(Stock s) {
		return stockRepo.save(s);
	}
	
	public List<Stock> findByNameLike(String nombre){
		return stockRepo.findByNameLike(nombre);
	}
	
	public Stock createRandom() {
		Pokemon pk = FAKER.pokemon();
		return new Stock(pk.name(), pk.location(),pk.location(),String.valueOf(FAKER.number().numberBetween(50, 100)),FAKER.number().numberBetween(5, 10)); //HACVEMEEE
	}
	
	public void delete(Stock s) {
		stockRepo.delete(s);
	}
	
	public List<Stock> findAll(){
		return stockRepo.findAll();
	}
}

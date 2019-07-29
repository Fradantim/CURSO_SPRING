package edu.educacionit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.educacionit.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
	
	@Query("Select s from Stock s where s.nombre like %:nombre%")
	public List<Stock> findByNameLike(String nombre);
}

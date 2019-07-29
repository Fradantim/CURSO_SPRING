package edu.educacionit.controllers;


import edu.educacionit.components.ContenedorJPA;
import edu.educacionit.model.Stock;
import edu.educacionit.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    
    @Autowired
    ContenedorJPA contenedorJPA;
    
    @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String stocks() {
        
        EntityManager em = contenedorJPA.getEm();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Stock stock = new Stock();
        
        stock.setId(java.util.UUID.randomUUID().toString());
        stock.setMarca("Bosch");
        stock.setNombre("Taladro");
        stock.setPeso("2 Kgm");
        stock.setSector("Ferreteria");
        stock.setUnidades(100);
        
        em.persist(stock);
        tx.commit();
        
        return "OK";
    }
}

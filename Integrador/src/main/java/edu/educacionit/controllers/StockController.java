package edu.educacionit.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.educacionit.model.Stock;
import edu.educacionit.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
    
    @Autowired
    private StockService stockService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Stock soloUno(@PathVariable("id") Long id) {
        return stockService.findById(id);
    }
    
    @RequestMapping(value = "/createRandom/{cant}", method = RequestMethod.GET)
    @ResponseBody
    public List<Stock> createRandom(@PathVariable("cant") Integer cant) {
        
    	List<Stock> stockNuevo = new ArrayList<>();
    	
        for(int i=0; i< cant; i++) {
        	stockNuevo.add(stockService.save(stockService.createRandom()));
        }
            	
    	return stockNuevo;
    }
    
    // -> /stock?nombre=a
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Stock> buscarNombre(@RequestParam(required = false) String nombre) {
    	if(nombre == null || nombre.isEmpty())
    		return stockService.findAll();
    	else
    		return stockService.findByNameLike(nombre);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> modificar(
            @PathVariable("id") Long id,
            @RequestBody Stock stock) {
        
    	Stock myStock = stockService.findById(id);
    	
    	if(myStock == null) {
    		//ese id no existe, puedo elegir negar el pedido o dar la alta
    		return new ResponseEntity<>("No existe stock con id: " +id, HttpStatus.GONE);
    	}
    	
    	if(myStock.equals(stock)) {
    		return new ResponseEntity<>("Objeto no modificado", HttpStatus.NOT_MODIFIED);
    	}

    	myStock = stockService.save(myStock.modify(stock));
    	return new ResponseEntity<>(myStock, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> insertar(@RequestBody Stock stock) {
    	return new ResponseEntity<>(stockService.save(stock), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> borrar(@PathVariable Long id) {
    	Stock myStock = stockService.findById(id);
    	if(myStock == null) {
    		return new ResponseEntity<>("No existe stock con id: " +id, HttpStatus.GONE);
    	}
    	
    	stockService.delete(myStock);
        return new ResponseEntity<>("Recibi: " + id, HttpStatus.OK);
    }
}

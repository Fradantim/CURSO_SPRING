package edu.educacionit.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.educacionit.model.Chofer;
import edu.educacionit.repository.choferes.ChoferRepository;

@Service
public class FiltroChoferes {

	private ChoferRepository choferRepo;
	
	@Autowired
	public FiltroChoferes(ChoferRepository choferRepository) {
		this.choferRepo=choferRepository;
	}
	
	public List<Chofer> getAll(){
		return choferRepo.getChoferes();
	}
	
	public List<Chofer> getChoferesQueLesGustaSuTrabajoConAccidentes(){
		return choferRepo.getChoferes().stream()
		  .filter(c -> c.getLeGustaSuTrabajo() && c.getCantAccidentes().compareTo(0) > 0)
		  .collect(Collectors.toList());
	}
	
	//Implementacion in-line de Function
	public List<Chofer> getChoferesQueLesGustaSuTrabajoSinAccidentes() {
		return getByFilterPredicate(c -> c.getLeGustaSuTrabajo() && c.getCantAccidentes().equals(0));
	}

	//Implementacion in-line de Function
	public List<Chofer> getChoferesQueNoLesGustaSuTrabajosSinAccidentes(){
		return getByFilterPredicate(c -> !c.getLeGustaSuTrabajo() && c.getCantAccidentes().equals(0));
	}
	
	public List<Chofer> getByFilterPredicate(Function<Chofer,Boolean> fn){
		return choferRepo.getChoferes().stream()
			.filter(c -> fn.apply(c))
			.collect(Collectors.toList());
	}
}

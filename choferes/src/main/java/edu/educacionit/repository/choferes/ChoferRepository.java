package edu.educacionit.repository.choferes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import edu.educacionit.model.Chofer;

@Component
public class ChoferRepository {

	private static final Faker FAKER = new Faker();
	private static final Integer CANT_CHOFERES = 8;
	
	private static final List<Chofer> CHOFERES_BD = new ArrayList<Chofer>();
	
	static {
		for(int i=0; i<CANT_CHOFERES; i++) {
			CHOFERES_BD.add(
					new Chofer(UUID.randomUUID(),
							FAKER.name().firstName(),
							FAKER.name().lastName(),
							FAKER.bool().bool(),
							FAKER.number().numberBetween(0, 6))
					);
		}
	}
	
	public List<Chofer> getChoferes(){
		return CHOFERES_BD;
	}
	
}

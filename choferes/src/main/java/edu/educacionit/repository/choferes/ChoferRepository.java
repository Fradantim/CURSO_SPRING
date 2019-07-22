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
	private static final Integer cantChoferes = 8;
	
	private List<Chofer> choferesBD;
	
	public List<Chofer> getChoferes(){
		if(choferesBD == null) {
			fillBD();
		}
		return choferesBD;
	}
	
	private void fillBD() {
		choferesBD = new ArrayList<Chofer>();
		for(int i=0; i<cantChoferes; i++) {
			choferesBD.add(
					new Chofer(UUID.randomUUID(),
							FAKER.name().firstName(),
							FAKER.name().lastName(),
							FAKER.bool().bool(),
							FAKER.number().numberBetween(0, 6))
					);
		}
	}
}

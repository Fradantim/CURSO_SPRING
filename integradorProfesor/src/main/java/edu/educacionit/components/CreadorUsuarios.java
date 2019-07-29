package edu.educacionit.components;

import com.github.javafaker.Faker;
import edu.educacionit.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class CreadorUsuarios {

    public CreadorUsuarios() {
    }
    
    public List<Usuario> crearUsuarios(int cantidad) {
        
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Faker faker = new Faker();
        
        for (int x = 0; x < cantidad; x++) {
            String usrName = faker.name().username();
            String pass = usrName.split("\\.")[0] + faker.address().streetAddressNumber();
            
            usuarios.add(new Usuario(
                    UUID.randomUUID().toString(),
                    usrName,
                    pass,
                    new String[] {"ROLE_ADMIN", "ROLE_OPERATOR", "ROLE_USER"}
            ));
        }
        
        return usuarios;
    }
}

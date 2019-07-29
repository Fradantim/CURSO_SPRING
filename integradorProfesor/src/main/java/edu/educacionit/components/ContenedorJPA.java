package edu.educacionit.components;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Component;

@Component
public class ContenedorJPA {

    private EntityManager em = null;
    
    public ContenedorJPA() {
        javax.persistence.EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory("pueclipse");

	em = emf.createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }
}

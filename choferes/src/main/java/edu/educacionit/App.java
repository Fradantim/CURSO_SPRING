package edu.educacionit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import edu.educacionit.model.Chofer;
import edu.educacionit.service.FiltroChoferes;

@Configuration
@ComponentScan({"edu.educacionit"})
@PropertySource("app.properties")
class AppConfig {
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer get() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        
        FiltroChoferes filtroChoferes = appContext.getBean(FiltroChoferes.class);
        
        System.out.println("getAll");
        for(Chofer chofer : filtroChoferes.getAll()) {
        	System.out.println(chofer);
        }
        
        System.out.println();
        System.out.println("getChoferesQueLesGustaSuTrabajoConAccidentes");
        for(Chofer chofer : filtroChoferes.getChoferesQueLesGustaSuTrabajoConAccidentes()) {
        	System.out.println(chofer);
        }
        
        System.out.println();
        System.out.println("getChoferesQueLesGustaSuTrabajoSinAccidentes");
        for(Chofer chofer : filtroChoferes.getChoferesQueLesGustaSuTrabajoSinAccidentes()) {
        	System.out.println(chofer);
        }
        
        System.out.println();
        System.out.println("getChoferesQueNoLesGustaSuTrabajoConAccidentes");
        for(Chofer chofer : filtroChoferes.getChoferesQueNoLesGustaSuTrabajoConAccidentes()) {
        	System.out.println(chofer);
        }
        
        System.out.println();
        System.out.println("getChoferesQueNoLesGustaSuTrabajosSinAccidentes");
        for(Chofer chofer : filtroChoferes.getChoferesQueNoLesGustaSuTrabajosSinAccidentes()) {
        	System.out.println(chofer);
        }
        
        ((AbstractApplicationContext) appContext).close();
    }
}

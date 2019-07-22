package edu.educacionit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

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
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
    }
}

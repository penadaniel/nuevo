package Reto3.Reto3;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "Modelo")

//@EnableConfigurationProperties
//@EntityScan(basePackages = {"Modelo"})
@SpringBootApplication
public class Reto3Application {
    
        
	public static void main(String[] args) {
		SpringApplication.run(Reto3Application.class, args);
	}

}

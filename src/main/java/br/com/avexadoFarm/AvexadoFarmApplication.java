package br.com.avexadoFarm;

import br.com.avexadoFarm.application.configuration.ApplicationConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfigurationProperties.class)
public class AvexadoFarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvexadoFarmApplication.class, args);
	}

}

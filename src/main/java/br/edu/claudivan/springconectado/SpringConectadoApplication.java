package br.edu.claudivan.springconectado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.edu.claudivan.springconectado.domain")
public class SpringConectadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConectadoApplication.class, args);
	}

}

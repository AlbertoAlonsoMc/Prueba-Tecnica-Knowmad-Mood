package com.knowmadmood.prueba_tecnica_alberto_alonso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PruebaTecnicaAlbertoAlonsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaAlbertoAlonsoApplication.class, args);
	}

}

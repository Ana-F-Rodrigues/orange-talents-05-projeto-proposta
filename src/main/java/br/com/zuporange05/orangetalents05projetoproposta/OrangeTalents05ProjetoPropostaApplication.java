package br.com.zuporange05.orangetalents05projetoproposta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class OrangeTalents05ProjetoPropostaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangeTalents05ProjetoPropostaApplication.class, args);
	}

}

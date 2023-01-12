package fr.jeuxminicie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class JeuxMiniCieApplication {

	
	public static void main(String[] args) throws Exception {

		SpringApplication.run(JeuxMiniCieApplication.class, args);
		
	}

}

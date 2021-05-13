package br.com.unip.base;


//mudar applicatio.properties
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("br.com.unip.aps.chat.Controller")
@EntityScan("br.com.unip.aps.modelo")
@EnableJpaRepositories ("br.com.unip.aps.repository")
@ComponentScan("br.com.unip.aps.service")
public class ApsChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApsChatApplication.class, args);
	}

}

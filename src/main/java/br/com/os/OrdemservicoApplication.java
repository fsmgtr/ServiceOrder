package br.com.os;



 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 

@EntityScan(basePackages = "br.com.os.domain")
@EnableTransactionManagement

@EnableWebMvc
@SpringBootApplication
public class OrdemservicoApplication   {

	public static void main(String[] args) {
		SpringApplication.run(OrdemservicoApplication.class, args);
	}

	

}

package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.os.service.DBService;

@Configuration
@Profile("teste")
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;

	@Bean
	public boolean instaciaDB() {
		if (ddl.equals("create")) {
			this.dbService.instaciaDB();
		}
		return false;
	}

}

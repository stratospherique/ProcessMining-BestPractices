package slr.master.stratospherique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@SpringBootApplication
public class StratospheriqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(StratospheriqueApplication.class, args);
	}
}

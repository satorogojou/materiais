package ifrn.pi.materiais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MateriaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MateriaisApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}

}

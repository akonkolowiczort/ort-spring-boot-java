package uy.edu.ort.ortspringbootjava;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class OrtSpringBootJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrtSpringBootJavaApplication.class, args);
	}
}

@RestController
class PersonaController {

	@Value("${personas.dummy}")
	private String personasDummy;

	@GetMapping("personas")
	public List<String> findPersonas() {
		return Stream.of(personasDummy.split(",")).map(String::trim).collect(Collectors.toList());
	}

}

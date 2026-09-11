package br.edu.iftm.petvida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.iftm.petvida.model.Animal;
import br.edu.iftm.petvida.model.Tutor;
import br.edu.iftm.petvida.repository.AnimalRepository;
import br.edu.iftm.petvida.repository.TutorRepository;

@SpringBootApplication
public class PetvidaApplication implements CommandLineRunner {

	@Autowired
	AnimalRepository animalRepository;

	@Autowired
	TutorRepository tutorRepository;

	@Override
	public void run(String... args) throws Exception {
		Tutor tutor1 = new Tutor(1L, "Marina Alves", "34 99101-0001");
		Tutor tutor2 = new Tutor(2L, "Carlos Prado", "34 99101-0002");
		tutorRepository.salvar(tutor1);
		tutorRepository.salvar(tutor2);

		Animal animal1 = new Animal(2L, "Mimi", "gato", 3, tutor1);
		Animal animal2 = new Animal(3L, "Thor", "cao", 1, tutor2);
		Animal animal3 = new Animal(4L, "Lila", "gato", 11, tutor2);
		animalRepository.salvar(animal1);
		animalRepository.salvar(animal2);
		animalRepository.salvar(animal3);

		Tutor eu = new Tutor(153L, "Edson", "34 95353-5353");
		Animal meuAnimal = new Animal(153L, "Pet_53", "cao", 53, eu);
		tutorRepository.salvar(eu);
		animalRepository.salvar(meuAnimal);
		System.out.println("Aplicação iniciada com sucesso!");
	}

	public static void main(String[] args) {
		SpringApplication.run(PetvidaApplication.class, args);
	}

}

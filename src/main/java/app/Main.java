package app;

import app.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static app.PersonSpecifications.*;
import static org.springframework.data.jpa.domain.Specification.where;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        List<Person> foundList = repository.findAll(hasName("Name"));

        System.out.println("---------------------------Found users By Name:---------------------------");
        for (Person person : foundList) {
            printPerson(person);
        }

        foundList = repository.findAll(where(hasName("Name")).and(hasAgeGraterThan(18)));
        System.out.println("---------------------------Found users By Name and Age:---------------------------");
        for (Person person : foundList) {
            printPerson(person);
        }

        foundList = repository.findAll(where(hasName("Name").and(hasAgeGraterThan(15)).and(hasCountry("Latvia"))));
        System.out.println("---------------------------Found users By Name , Age, Country:---------------------------");
        for (Person person : foundList) {
            printPerson(person);
        }

        foundList = repository.findAll(where(hasName("Homer").or(hasCountry("Russia"))));
        System.out.println("---------------------------Found users By Name or Country:---------------------------");
        for (Person person : foundList) {
            printPerson(person);
        }
    }

    private void printPerson(Person person) {
        System.out.println("Id: " + person.getId());
        System.out.println("Name: " + person.getName());
        System.out.println("Surname: " + person.getSurname());
        System.out.println("Age: " + person.getAge());
        System.out.println("Country: " + person.getCountry());
        System.out.println("Date: " + person.getDate());
        System.out.println("E-Mail: " + person.getEmail());
        System.out.println("");
    }

}

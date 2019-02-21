package app;

import app.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    UserDAO userDao;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        List<Person> foundList = userDao.findAllPersonsByName("Name");

        System.out.println("---------------------------Found users By Name:---------------------------");
        for (Person person : foundList) {
            System.out.println("Id: " + person.getId());
            System.out.println("Name: " + person.getName());
            System.out.println("Surname: " + person.getSurname());
            System.out.println("Age: " + person.getAge());
            System.out.println("Country: " + person.getCountry());
            System.out.println("Date: " + person.getDate());
            System.out.println("E-Mail: " + person.getEmail());
            System.out.println("");
        }

        foundList = userDao.findByNameAndAge("Name", 22);
        System.out.println("---------------------------Found users By Name and Age:---------------------------");
        for (Person person : foundList) {
            System.out.println("Id: " + person.getId());
            System.out.println("Name: " + person.getName());
            System.out.println("Surname: " + person.getSurname());
            System.out.println("Age: " + person.getAge());
            System.out.println("Country: " + person.getCountry());
            System.out.println("Date: " + person.getDate());
            System.out.println("E-Mail: " + person.getEmail());
            System.out.println("");
        }

        foundList = userDao.findByNameNotEquals("Name");
        System.out.println("---------------------------Found users By Name not Like:---------------------------");
        for (Person person : foundList) {
            System.out.println("Id: " + person.getId());
            System.out.println("Name: " + person.getName());
            System.out.println("Surname: " + person.getSurname());
            System.out.println("Age: " + person.getAge());
            System.out.println("Country: " + person.getCountry());
            System.out.println("Date: " + person.getDate());
            System.out.println("E-Mail: " + person.getEmail());
            System.out.println("");
        }

        foundList = userDao.findByNameOrCountryEquals("Homer", "Latvia");
        System.out.println("---------------------------Found users By Name or Country:---------------------------");
        for (Person person : foundList) {
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

}

package app;

import app.domain.Person;
import org.springframework.data.jpa.domain.Specification;

public class PersonSpecifications {
         static Specification<Person> hasName(String name) {
        return (person, query, criteriaBuilder) -> criteriaBuilder.equal(person.get("name"), name);
    }

    static Specification<Person> hasAgeGraterThan(int age) {
        return (person, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(person.get("age"), age);
    }

    static Specification<Person> hasCountry(String country){
             return (person, query, criteriaBuilder) -> criteriaBuilder.equal(person.get("country"), country);
    }
}

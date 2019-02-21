package app;

import app.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class UserDAO {

    @Autowired
    private EntityManager entityManager;

    List<Person> findAllPersonsByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);

        Root<Person> person = criteriaQuery.from(Person.class);
        Predicate namePredicate = criteriaBuilder.equal(person.get("name"), name);
        criteriaQuery.where(namePredicate);

        TypedQuery<Person> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    List<Person> findByNameAndAge(String name, int age) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);

        Root<Person> person = criteriaQuery.from(Person.class);
        Predicate namePredicate = criteriaBuilder.equal(person.get("name"), name);
        Predicate agePredicate = criteriaBuilder.greaterThanOrEqualTo(person.get("age"), age);
        criteriaQuery.where(namePredicate, agePredicate);

        TypedQuery<Person> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    List<Person> findByNameNotEquals(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);

        Root<Person> person = criteriaQuery.from(Person.class);
        Predicate agePredicate = criteriaBuilder.notLike(person.get("name"), name);
        criteriaQuery.where(agePredicate);

        TypedQuery<Person> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    List<Person> findByNameOrCountryEquals(String name, String coutry) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);

        Root<Person> person = criteriaQuery.from(Person.class);
        Predicate agePredicate = criteriaBuilder.equal(person.get("name"), name);
        Predicate countryPredicate = criteriaBuilder.equal(person.get("country"), coutry);
        criteriaQuery.where(criteriaBuilder.or(agePredicate,countryPredicate));

        TypedQuery<Person> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}

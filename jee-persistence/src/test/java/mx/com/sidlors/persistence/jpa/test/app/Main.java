package mx.com.sidlors.persistence.jpa.test.app;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
  private static final Logger LOGGER = Logger.getLogger( "JPA" );

  public static void main( String[] args ) {
    Main main = new Main();
    main.run();
  }

  public void run() {
    EntityManagerFactory factory = null;
    EntityManager entityManager = null;
    try{
      factory = Persistence.createEntityManagerFactory( "PersistenceUnitTest" );
      entityManager = factory.createEntityManager();
      persistPerson( entityManager );
      persistGeek( entityManager );
      // loadPersons(entityManager);
      addPhones( entityManager );
      createProject( entityManager );
      queryProject( entityManager );
    }
    catch( Exception e ){
      LOGGER.log( Level.SEVERE, e.getMessage(), e );
      e.printStackTrace();
    }
    finally{
      if( entityManager != null ){
        entityManager.close();
      }
      if( factory != null ){
        factory.close();
      }
    }
  }

  private void queryProject( EntityManager entityManager ) {

  }

  private void createProject( EntityManager entityManager ) {

  }

  private void addPhones( EntityManager entityManager ) {
  }

  public void persistPerson( EntityManager entityManager ) {
    // EntityTransaction transaction = entityManager.getTransaction();
    // try {
    // transaction.begin();
    // Person person = new Person();
    // person.setFirstName("Homer");
    // person.setLastName("Simpson");
    // entityManager.persist(person);
    // IdCard idCard = new IdCard();
    // idCard.setIdNumber("4711");
    // idCard.setIssueDate(new Date());
    // person.setIdCard(idCard);
    // entityManager.persist(idCard);
    // transaction.commit();
    // } catch (Exception e) {
    // if (transaction.isActive()) {
    // transaction.rollback();
    // }
    // }
  }

  public void persistGeek( EntityManager entityManager ) {
  }

  // public List<Person> loadPersons(EntityManager entityManager) {
  // entityManager.clear();
  // TypedQuery<Person> query = entityManager.createQuery("from Person p left join fetch p.phones", Person.class);
  // List<Person> resultList = query.getResultList();
  // for (Person person : resultList) {
  // StringBuilder sb = new StringBuilder();
  // sb.append(person.getFirstName()).append(" ").append(person.getLastName());
  // if (person instanceof Geek) {
  // Geek geek = (Geek)person;
  // sb.append(" ").append(geek.getFavouriteProgrammingLanguage());
  // }
  // IdCard idCard = person.getIdCard();
  // if (idCard != null) {
  // sb.append(" ").append(idCard.getIdNumber()).append(" ").append(idCard.getIssueDate());
  // }
  // List<Phone> phones = person.getPhones();
  // for (Phone phone : phones) {
  // sb.append(" ").append(phone.getNumber());
  // }
  // LOGGER.info(sb.toString());
  // }
  //
  // return resultList;
  // }
}
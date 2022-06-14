package pl.sda.sapiens.ep.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pl.sda.sapiens.ep.model.entity.TagEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class HibernatTagRepository implements TagRepository{

    private final EntityManager entityManager;
    private EntityTransaction transaction;


    public HibernatTagRepository(SessionFactory sessionFactory) {
        entityManager = sessionFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public boolean saveIfNotPresent(String tag) {
       transaction.begin();
       entityManager.persist(new TagEntity(0,tag, null ));
       transaction.commit();
       return true;
    }
}

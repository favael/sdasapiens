package pl.sda.sapiens.ep.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pl.sda.sapiens.ep.model.entity.EventEntity;
import pl.sda.sapiens.ep.model.entity.TagEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Set;

@Repository
public class HibernatTagRepository implements TagRepository{

    private final EntityManager entityManager;
    private EntityTransaction transaction;


    public HibernatTagRepository(SessionFactory sessionFactory) {
        entityManager = sessionFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public boolean saveIfNotPresent(String tag, EventEntity event) {
       transaction.begin();
       entityManager.persist(new TagEntity(0,tag, Set.of(event) ));
       transaction.commit();
       return true;
    }
}

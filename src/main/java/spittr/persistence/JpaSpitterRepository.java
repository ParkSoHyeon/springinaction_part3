package spittr.persistence;

import org.springframework.stereotype.Repository;
import spittr.data.SpitterRepository;
import spittr.domain.Spitter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JpaSpitterRepository implements SpitterRepository{
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    public void addSpitter(Spitter spitter) {
//        entityManagerFactory.createEntityManager().persist(spitter);
        entityManager.persist(spitter);
    }
    public Spitter getSpitterById(long id) {
//        return entityManagerFactory.createEntityManager().find(Spitter.class, id);
        return entityManager.find(Spitter.class, id);
    }


    public void saveSpitter(Spitter spitter) {
//        entityManagerFactory.createEntityManager().merge(spitter)
        entityManager.merge(spitter);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Spitter save(Spitter spitter) {
        return null;
    }

    @Override
    public Spitter findOne(long id) {
        return null;
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }

    @Override
    public List<Spitter> findAll() {
        return null;
    }
}

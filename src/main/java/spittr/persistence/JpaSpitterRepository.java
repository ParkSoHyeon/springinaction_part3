package spittr.persistence;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Repository;
import spittr.data.SpitterRepository;
import spittr.domain.Spitter;

import javax.annotation.security.RolesAllowed;
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

//    @Secured({"ROLE_SPITTER", "ROLE_ADMIN"})
//    @RolesAllowed("ROLE_SPITTER")
    @PreAuthorize("(hasRole('ROLE_SPITTER') and #spitter.fullName.length() <= 10) or hasRole('ROLE_PREMIUM')")
    public void addSpitter(Spitter spitter) {
//        entityManagerFactory.createEntityManager().persist(spitter);
        entityManager.persist(spitter);
    }

    @PostAuthorize("returnObject.username == principal.username")
    public Spitter getSpitterById(long id) {
//        return entityManagerFactory.createEntityManager().find(Spitter.class, id);
        return entityManager.find(Spitter.class, id);
    }

    public void saveSpitter(Spitter spitter) {
//        entityManagerFactory.createEntityManager().merge(spitter)
        entityManager.merge(spitter);
    }

    @PreAuthorize("hasAnyRole({'ROLE_SPITTER', 'ROLE_ADMIN'})")
    @PostFilter("hasRole('ROLE_ADMIN') || filterObject.username == principal.username")
    public List<Spitter> getOffensiveSpitters() {
        return null;
    }


    @PreAuthorize("hasAnyRole({'ROLE_SPITTER', 'ROLE_ADMIN'})")
//    @PreFilter("hasRole('ROLE_ADMIN') || filterObject.username == principal.username")
    @PreFilter("hasPermission(filterObject, 'delete')")
    public void deleteSpitters(List<Spitter> spitters) {

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

    @Override
    public void remove(long spitterId) {

    }
}

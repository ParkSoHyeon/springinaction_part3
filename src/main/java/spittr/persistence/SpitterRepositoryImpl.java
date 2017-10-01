package spittr.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SpitterRepositoryImpl implements SpitterSweeper {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int eliteSweep() {
       String update =
               "UPDATE Spitter spitter " +
                       "SET spitter.status = 'Elite' " +
                       "WHERE spitter.id IN (" +
                       "SELECT s FROM Spitter s WHERE (SELECT COUNT(spittles) FROM s.spittles spittles) > 10000)";

       return entityManager.createQuery(update).executeUpdate();
    }
}

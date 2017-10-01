package spittr.data;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import spittr.domain.Spitter;

import javax.inject.Inject;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {
    private static final String INSERT_SPITTER = "";
    private JdbcOperations jdbcOperations;

    @Inject
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;

    }

    public void addSpitter(Spitter spitter) {
        jdbcOperations.update(INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword());
    }
    @Override
    public Spitter save(Spitter unsaved) {
        return null;
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }
}

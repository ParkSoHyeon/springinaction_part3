package spittr.data;

import spittr.domain.Spitter;

import java.util.List;

public interface SpitterRepository {
    long count();

    spittr.domain.Spitter save(Spitter spitter);

    spittr.domain.Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}

package spittr.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spittr.domain.Spitter;

import java.util.List;

public interface SpitterRepository extends JpaRepository<Spitter, Long> {
    Spitter findBYUsername(String username);

    List<Spitter> readByFirstnameOrLastname(String first, String last);

    List<Spitter> readByFirstnameIgnoringCaseOrLastnameIgnoresCase(String fise, String last);

    List<Spitter> readByFirstnameOfLastnameAllIgnoresCase(String first, String last);

    List<Spitter> readByFistnameOrLastnameOrderByLastnameAsc(String first, String last);

    List<Spitter> readByFirstnameOfLastnameOrderByLastnameAscFirstnameDesc(String first, String last);

    @Query("select s from Spitter s where s.email like '%gamil.com'")
    List<Spitter> findAllGmailSpitters();
}

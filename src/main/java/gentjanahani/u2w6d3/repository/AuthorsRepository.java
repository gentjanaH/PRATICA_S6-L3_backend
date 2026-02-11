package gentjanahani.u2w6d3.repository;

import gentjanahani.u2w6d3.entities.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, UUID> {

    Optional<Authors> findByEmail(String email);
}

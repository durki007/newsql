package pl.pwr.backendnbadraft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.backendnbadraft.model.Club;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByName(String name);
    List<Club> findByRegionCode(String regionCode);
    List<Club> findByConference(String conference);
    List<Club> findByDivision(String division);
} 
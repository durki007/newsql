package pl.pwr.backendnbadraft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.backendnbadraft.model.Player;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByClubId(Long clubId);
    List<Player> findByPlayerCategory(String playerCategory);
    List<Player> findByLastNameContainingIgnoreCase(String lastName);
    List<Player> findByPositionIgnoreCase(String position);
    List<Player> findByDraftYear(Integer draftYear);
} 
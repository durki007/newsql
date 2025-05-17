package pl.pwr.backendnbadraft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pwr.backendnbadraft.model.Player;
import pl.pwr.backendnbadraft.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> findPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public List<Player> findPlayersByClubId(Long clubId) {
        return playerRepository.findByClubId(clubId);
    }

    public List<Player> findPlayersByPlayerCategory(String playerCategory) {
        return playerRepository.findByPlayerCategory(playerCategory);
    }

    public List<Player> findPlayersByLastName(String lastName) {
        return playerRepository.findByLastNameContainingIgnoreCase(lastName);
    }

    public List<Player> findPlayersByPosition(String position) {
        return playerRepository.findByPositionIgnoreCase(position);
    }

    public List<Player> findPlayersByDraftYear(Integer draftYear) {
        return playerRepository.findByDraftYear(draftYear);
    }
} 
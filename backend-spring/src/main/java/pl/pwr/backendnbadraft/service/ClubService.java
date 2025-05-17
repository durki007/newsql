package pl.pwr.backendnbadraft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pwr.backendnbadraft.model.Club;
import pl.pwr.backendnbadraft.repository.ClubRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;

    public List<Club> findAllClubs() {
        return clubRepository.findAll();
    }

    public Optional<Club> findClubById(Long id) {
        return clubRepository.findById(id);
    }

    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    public void deleteClub(Long id) {
        clubRepository.deleteById(id);
    }

    public List<Club> findClubsByRegionCode(String regionCode) {
        return clubRepository.findByRegionCode(regionCode);
    }

    public List<Club> findClubsByConference(String conference) {
        return clubRepository.findByConference(conference);
    }

    public List<Club> findClubsByDivision(String division) {
        return clubRepository.findByDivision(division);
    }
} 
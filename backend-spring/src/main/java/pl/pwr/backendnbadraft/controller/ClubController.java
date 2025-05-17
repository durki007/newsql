package pl.pwr.backendnbadraft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.backendnbadraft.dto.ClubDto;
import pl.pwr.backendnbadraft.mapper.ClubMapper;
import pl.pwr.backendnbadraft.model.Club;
import pl.pwr.backendnbadraft.service.ClubService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clubs")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;
    private final ClubMapper clubMapper;

    @GetMapping
    public ResponseEntity<List<ClubDto>> getAllClubs() {
        List<ClubDto> clubs = clubService.findAllClubs().stream()
                .map(clubMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clubs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubDto> getClubById(@PathVariable Long id) {
        return clubService.findClubById(id)
                .map(clubMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClubDto> createClub(@RequestBody ClubDto clubDto) {
        Club club = clubMapper.toEntity(clubDto);
        Club savedClub = clubService.saveClub(club);
        return new ResponseEntity<>(clubMapper.toDto(savedClub), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClubDto> updateClub(@PathVariable Long id, @RequestBody ClubDto clubDto) {
        return clubService.findClubById(id)
                .map(existingClub -> {
                    Club club = clubMapper.toEntity(clubDto);
                    club.setId(id);
                    Club updatedClub = clubService.saveClub(club);
                    return ResponseEntity.ok(clubMapper.toDto(updatedClub));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable Long id) {
        return clubService.findClubById(id)
                .map(club -> {
                    clubService.deleteClub(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/region/{regionCode}")
    public ResponseEntity<List<ClubDto>> getClubsByRegionCode(@PathVariable String regionCode) {
        List<ClubDto> clubs = clubService.findClubsByRegionCode(regionCode).stream()
                .map(clubMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clubs);
    }

    @GetMapping("/conference/{conference}")
    public ResponseEntity<List<ClubDto>> getClubsByConference(@PathVariable String conference) {
        List<ClubDto> clubs = clubService.findClubsByConference(conference).stream()
                .map(clubMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clubs);
    }

    @GetMapping("/division/{division}")
    public ResponseEntity<List<ClubDto>> getClubsByDivision(@PathVariable String division) {
        List<ClubDto> clubs = clubService.findClubsByDivision(division).stream()
                .map(clubMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clubs);
    }
} 
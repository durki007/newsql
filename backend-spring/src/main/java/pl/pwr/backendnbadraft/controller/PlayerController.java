package pl.pwr.backendnbadraft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.backendnbadraft.dto.PlayerDto;
import pl.pwr.backendnbadraft.mapper.PlayerMapper;
import pl.pwr.backendnbadraft.model.Player;
import pl.pwr.backendnbadraft.service.ClubService;
import pl.pwr.backendnbadraft.service.PlayerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    private final ClubService clubService;
    private final PlayerMapper playerMapper;

    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        List<PlayerDto> players = playerService.findAllPlayers().stream()
                .map(playerMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long id) {
        return playerService.findPlayerById(id)
                .map(playerMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto) {
        Player player = playerMapper.toEntity(playerDto);
        
        if (playerDto.clubId() != null) {
            clubService.findClubById(playerDto.clubId())
                    .ifPresent(player::setClub);
        }
        
        Player savedPlayer = playerService.savePlayer(player);
        return new ResponseEntity<>(playerMapper.toDto(savedPlayer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Long id, @RequestBody PlayerDto playerDto) {
        return playerService.findPlayerById(id)
                .map(existingPlayer -> {
                    Player player = playerMapper.toEntity(playerDto);
                    player.setId(id);
                    
                    if (playerDto.clubId() != null) {
                        clubService.findClubById(playerDto.clubId())
                                .ifPresent(player::setClub);
                    }
                    
                    Player updatedPlayer = playerService.savePlayer(player);
                    return ResponseEntity.ok(playerMapper.toDto(updatedPlayer));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        return playerService.findPlayerById(id)
                .map(player -> {
                    playerService.deletePlayer(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/club/{clubId}")
    public ResponseEntity<List<PlayerDto>> getPlayersByClubId(@PathVariable Long clubId) {
        List<PlayerDto> players = playerService.findPlayersByClubId(clubId).stream()
                .map(playerMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(players);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<PlayerDto>> getPlayersByCategory(@PathVariable String category) {
        List<PlayerDto> players = playerService.findPlayersByPlayerCategory(category).stream()
                .map(playerMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(players);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PlayerDto>> getPlayersByLastName(@RequestParam String lastName) {
        List<PlayerDto> players = playerService.findPlayersByLastName(lastName).stream()
                .map(playerMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(players);
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<List<PlayerDto>> getPlayersByPosition(@PathVariable String position) {
        List<PlayerDto> players = playerService.findPlayersByPosition(position).stream()
                .map(playerMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(players);
    }

    @GetMapping("/draft/{year}")
    public ResponseEntity<List<PlayerDto>> getPlayersByDraftYear(@PathVariable Integer year) {
        List<PlayerDto> players = playerService.findPlayersByDraftYear(year).stream()
                .map(playerMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(players);
    }
} 
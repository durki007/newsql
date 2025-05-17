package pl.pwr.backendnbadraft.mapper;

import org.springframework.stereotype.Component;
import pl.pwr.backendnbadraft.dto.PlayerDto;
import pl.pwr.backendnbadraft.model.Player;

@Component
public class PlayerMapper {

    public PlayerDto toDto(Player player) {
        if (player == null) {
            return null;
        }
        
        Long clubId = null;
        String clubName = null;
        if (player.getClub() != null) {
            clubId = player.getClub().getId();
            clubName = player.getClub().getName();
        }
        
        return new PlayerDto(
                player.getId(),
                player.getFirstName(),
                player.getLastName(),
                player.getJerseyNumber(),
                player.getPosition(),
                player.getHeightCm(),
                player.getWeightKg(),
                player.getDateOfBirth(),
                player.getNationality(),
                player.getPlayerCategory(),
                player.getDraftYear(),
                player.getDraftPosition(),
                player.getSalary(),
                clubId,
                clubName
        );
    }

    public Player toEntity(PlayerDto playerDto) {
        if (playerDto == null) {
            return null;
        }
        
        return Player.builder()
                .id(playerDto.id())
                .firstName(playerDto.firstName())
                .lastName(playerDto.lastName())
                .jerseyNumber(playerDto.jerseyNumber())
                .position(playerDto.position())
                .heightCm(playerDto.heightCm())
                .weightKg(playerDto.weightKg())
                .dateOfBirth(playerDto.dateOfBirth())
                .nationality(playerDto.nationality())
                .playerCategory(playerDto.playerCategory())
                .draftYear(playerDto.draftYear())
                .draftPosition(playerDto.draftPosition())
                .salary(playerDto.salary())
                .build();
    }
} 
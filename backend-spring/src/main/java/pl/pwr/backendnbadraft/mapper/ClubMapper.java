package pl.pwr.backendnbadraft.mapper;

import org.springframework.stereotype.Component;
import pl.pwr.backendnbadraft.dto.ClubDto;
import pl.pwr.backendnbadraft.model.Club;

@Component
public class ClubMapper {

    public ClubDto toDto(Club club) {
        if (club == null) {
            return null;
        }
        
        return new ClubDto(
                club.getId(),
                club.getName(),
                club.getCity(),
                club.getConference(),
                club.getDivision(),
                club.getFoundingYear(),
                club.getArenaName(),
                club.getOwnerName(),
                club.getRegionCode()
        );
    }

    public Club toEntity(ClubDto clubDto) {
        if (clubDto == null) {
            return null;
        }
        
        return Club.builder()
                .id(clubDto.id())
                .name(clubDto.name())
                .city(clubDto.city())
                .conference(clubDto.conference())
                .division(clubDto.division())
                .foundingYear(clubDto.foundingYear())
                .arenaName(clubDto.arenaName())
                .ownerName(clubDto.ownerName())
                .regionCode(clubDto.regionCode())
                .build();
    }
} 
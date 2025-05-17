package pl.pwr.backendnbadraft.dto;

import java.util.Date;

public record PlayerDto(
    Long id,
    String firstName,
    String lastName,
    Integer jerseyNumber,
    String position,
    Integer heightCm,
    Double weightKg,
    Date dateOfBirth,
    String nationality,
    String playerCategory,
    Integer draftYear,
    Integer draftPosition,
    Double salary,
    Long clubId,
    String clubName
) {} 
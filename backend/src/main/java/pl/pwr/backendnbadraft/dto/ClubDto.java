package pl.pwr.backendnbadraft.dto;

public record ClubDto(
    Long id,
    String name,
    String city, 
    String conference,
    String division,
    Integer foundingYear,
    String arenaName,
    String ownerName,
    String regionCode
) {} 
package pl.pwr.backendnbadraft.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(name = "jersey_number")
    private Integer jerseyNumber;

    @Column(name = "position")
    private String position;

    @Column(name = "height_cm")
    private Integer heightCm;

    @Column(name = "weight_kg")
    private Double weightKg;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "nationality")
    private String nationality;

    // This field could be used for partitioning in CockroachDB
    @Column(name = "player_category", nullable = false)
    private String playerCategory; // e.g., "rookie", "veteran", "star", etc.

    @Column(name = "draft_year")
    private Integer draftYear;

    @Column(name = "draft_position")
    private Integer draftPosition;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Club club;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
} 
package com.date.datingapp.adapter.repository.match.model;

import com.date.datingapp.domain.enums.MatchStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(
        name = "match",
        schema = "match_service"
)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class MatchJpaEntity {

    @Id
    UUID id;

    @Column(name = "user_a", nullable = false)
    UUID userA;

    @Column(name = "user_b", nullable = false)
    UUID userB;

    @Column(name = "created_at", nullable = false)
    Instant createdAt;

    @Enumerated(EnumType.STRING)
    MatchStatus status;

}



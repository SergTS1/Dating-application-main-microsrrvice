package com.date.datingapp.adapter.repository.swipe.model;


import com.date.datingapp.domain.enums.SwipeType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;


import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "swipe",
        schema = "match_service")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class SwipeJpaEntity {

    @Id
    UUID id;

    @Column(name = "from_user", nullable = false)
    UUID from;

    @Column(name = "to_user", nullable = false)
    UUID to;

    @Column(name = "created_at", nullable = false)
    Instant createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "swipe_type", nullable = false)
    SwipeType type;
}

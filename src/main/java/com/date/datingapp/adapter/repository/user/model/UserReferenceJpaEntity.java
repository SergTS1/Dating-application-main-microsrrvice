package com.date.datingapp.adapter.repository.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Table(name = "user_reference",
        schema = "match_service")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserReferenceJpaEntity {

    @Id
    @Column(name = "user_id", nullable = false)
    UUID userId;

    public UserReferenceJpaEntity(UUID userId) {
        this.userId = userId;
    }
}

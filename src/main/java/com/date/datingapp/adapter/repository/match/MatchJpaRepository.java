package com.date.datingapp.adapter.repository.match;

import com.date.datingapp.adapter.repository.match.model.MatchJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatchJpaRepository extends JpaRepository<MatchJpaEntity, UUID> {
}

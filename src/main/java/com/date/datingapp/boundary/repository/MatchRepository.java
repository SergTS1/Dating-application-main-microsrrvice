package com.date.datingapp.boundary.repository;

import com.date.datingapp.domain.entity.match.Match;

import java.util.Optional;
import java.util.UUID;

public interface MatchRepository {

    void save(Match match);

    void deleteByMatchId(UUID uuid);

    Optional<Match> findById(UUID uuid);
}

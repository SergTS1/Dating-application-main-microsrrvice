package com.date.datingapp.adapter.repository.match;

import com.date.datingapp.boundary.repository.MatchRepository;
import com.date.datingapp.domain.entity.match.Match;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class MatchRepositoryImpl implements MatchRepository {

    public void save(Match match) {

    }

    public void deleteByMatchId(UUID uuid) {

    }

    public Optional<Match> findById(UUID uuid) {
        return Optional.empty();
    }

}

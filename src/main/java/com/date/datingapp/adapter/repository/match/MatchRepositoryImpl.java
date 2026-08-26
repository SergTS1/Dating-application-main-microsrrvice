package com.date.datingapp.adapter.repository.match;

import com.date.datingapp.adapter.repository.match.converter.MatchConverter;
import com.date.datingapp.boundary.repository.MatchRepository;
import com.date.datingapp.domain.entity.match.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MatchRepositoryImpl implements MatchRepository {

    private final MatchJpaRepository matchJpaRepository;
    private final MatchConverter matchConverter;

    @Override
    public void save(Match match) {
        matchJpaRepository.save(matchConverter.toEntity(match));
    }

    @Override
    public void deleteByMatchId(UUID uuid) {
        matchJpaRepository.deleteById(uuid);
    }

    @Override
    public Optional<Match> findById(UUID uuid) {
        return matchJpaRepository.findById(uuid)
                .map(matchConverter::toDomain);
    }

}

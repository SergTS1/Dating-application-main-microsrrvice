package com.date.datingapp.adapter.repository.match.converter;

import com.date.datingapp.adapter.repository.match.model.MatchJpaEntity;
import com.date.datingapp.domain.entity.match.Match;
import com.date.datingapp.domain.valueobject.MatchId;
import com.date.datingapp.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class MatchConverter {

    public MatchJpaEntity toEntity(Match match) {
        if (match == null) {
            return null;
        }
        MatchJpaEntity entity = new MatchJpaEntity();
        entity.setId(match.getId().value());
        entity.setUserA(match.getUserA().value());
        entity.setUserB(match.getUserB().value());
        entity.setCreatedAt(match.getCreatedAt());
        entity.setStatus(match.getStatus());
        return entity;
    }


    public Match toDomain(MatchJpaEntity entity) {
        return Match.restore(
                new MatchId(entity.getId()),
                new UserId(entity.getUserA()),
                new UserId(entity.getUserB()),
                entity.getCreatedAt(),
                entity.getStatus()
        );
    }
}

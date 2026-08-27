package com.date.datingapp.adapter.repository.swipe.converter;

import com.date.datingapp.adapter.repository.swipe.model.SwipeJpaEntity;
import com.date.datingapp.domain.entity.swipe.Swipe;
import com.date.datingapp.domain.valueobject.swipe.SwipeId;
import com.date.datingapp.domain.valueobject.user.UserId;
import org.springframework.stereotype.Component;

@Component
public class SwipeConverter {

    public SwipeJpaEntity toEntity(Swipe swipe) {
        if (swipe == null) {
            return null;
        }

        SwipeJpaEntity entity = new SwipeJpaEntity();
        entity.setId(swipe.getId().value());
        entity.setFrom(swipe.getFrom().value());
        entity.setTo(swipe.getTo().value());
        entity.setType(swipe.getType());
        entity.setCreatedAt(swipe.getCreatedAt());
        return entity;
    }

    public Swipe toDomain(SwipeJpaEntity entity) {
        return Swipe.restore(
                new SwipeId(entity.getId()),
                new UserId(entity.getFrom()),
                new UserId(entity.getTo()),
                entity.getType(),
                entity.getCreatedAt()
        );
    }
}

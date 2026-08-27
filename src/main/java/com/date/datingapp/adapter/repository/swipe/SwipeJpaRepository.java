package com.date.datingapp.adapter.repository.swipe;

import com.date.datingapp.adapter.repository.swipe.model.SwipeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SwipeJpaRepository extends JpaRepository<SwipeJpaEntity, UUID> {
}

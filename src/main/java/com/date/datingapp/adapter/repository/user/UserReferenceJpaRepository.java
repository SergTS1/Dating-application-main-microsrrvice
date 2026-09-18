package com.date.datingapp.adapter.repository.user;

import com.date.datingapp.adapter.repository.user.model.UserReferenceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserReferenceJpaRepository extends JpaRepository<UserReferenceJpaEntity, UUID> {
}

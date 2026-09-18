package com.date.datingapp.adapter.repository.user;

import com.date.datingapp.adapter.repository.user.model.UserReferenceJpaEntity;
import com.date.datingapp.boundary.repository.UserReferenceRepository;
import com.date.datingapp.domain.valueobject.user.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserReferenceRepositoryImpl implements UserReferenceRepository {

    private final UserReferenceJpaRepository userReferenceJpaRepository;

    @Override
    public boolean existsById(UserId userId) {
        return userReferenceJpaRepository.existsById(userId.value());
    }

    @Override
    public void save(UserId userId) {
        userReferenceJpaRepository.save(new UserReferenceJpaEntity(userId.value()));
    }
}

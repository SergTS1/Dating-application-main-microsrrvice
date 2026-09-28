package com.date.datingapp.boundary.repository;

import com.date.datingapp.domain.valueobject.user.UserId;

public interface UserReferenceRepository {

    boolean existsById(UserId id);

    void save(UserId userId);

    void deleteById(UserId userId);
}

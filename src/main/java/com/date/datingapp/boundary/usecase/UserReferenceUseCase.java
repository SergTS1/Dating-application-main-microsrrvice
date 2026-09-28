package com.date.datingapp.boundary.usecase;

import java.util.UUID;

public interface UserReferenceUseCase {

    void createUserReference(UUID userId);

    void deleteUserReference(UUID userId);
}

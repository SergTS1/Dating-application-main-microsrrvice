package com.date.datingapp.boundary.usecase;

import java.util.UUID;

public interface UserCreatedUseCase {

    void execute(UUID userId);
}

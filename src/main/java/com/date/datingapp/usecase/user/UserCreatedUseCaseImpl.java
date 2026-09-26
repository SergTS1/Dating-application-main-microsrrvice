package com.date.datingapp.usecase.user;

import com.date.datingapp.boundary.repository.UserReferenceRepository;
import com.date.datingapp.boundary.usecase.UserCreatedUseCase;
import com.date.datingapp.domain.valueobject.user.UserId;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class UserCreatedUseCaseImpl implements UserCreatedUseCase {

    UserReferenceRepository userReferenceRepository;

    public void execute(UUID userId) {
        UserId id = UserId.of(userId);
        if (userReferenceRepository.existsById(id)) {
            return;
        }
        userReferenceRepository.save(id);
    }
}

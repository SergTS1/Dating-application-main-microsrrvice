package com.date.datingapp.domain.usecase.user;

import com.date.datingapp.boundary.model.CreateUserParam;
import com.date.datingapp.boundary.model.UserInfo;
import com.date.datingapp.boundary.usecase.CreateUserUseCase;
import com.date.datingapp.boundary.usecase.GetUserUseCase;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase, GetUserUseCase {

    private Long idCount = 1L;
    private final Map<Long, UserInfo> bookings = new HashMap<>();

    @Override
    public UserInfo create(CreateUserParam params) {
        UserInfo userInfo = UserInfo.builder()
                .id(idCount)
                .uuid(UUID.randomUUID())
                .name(params.getName())
                .email(params.getEmail())
                .phoneNumber(params.getPhoneNumber())
                .createdAt(params.getCreatedAt())
                .build();

        idCount++;
        bookings.put(userInfo.getId(), userInfo);
        return bookings.get(userInfo.getId());
    }

    @Override
    public UserInfo getUserById(Long id) {
        UserInfo userinfo = bookings.get(id);

        if (userinfo == null) {
            throw new IllegalArgumentException("User Not found: " + id);
        }
        return userinfo;
    }

}

package com.date.datingapp.boundary.usecase;

import com.date.datingapp.boundary.model.UserInfo;

public interface GetUserUseCase {

    UserInfo getUserById(Long id);
}

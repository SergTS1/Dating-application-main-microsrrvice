package com.date.datingapp.boundary.usecase;

import com.date.datingapp.boundary.model.CreateUserParam;
import com.date.datingapp.boundary.model.UserInfo;


public interface CreateUserUseCase {

    UserInfo create(CreateUserParam params);
}

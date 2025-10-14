package com.date.datingapp.adapter.controller.http.convertor;


import com.date.datingapp.adapter.controller.http.request.CreateUserRequest;
import com.date.datingapp.boundary.model.CreateUserParam;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    default CreateUserParam toParam(CreateUserRequest request) {
        if (request == null || request.getData() == null || request.getData().getAttributes() == null) {
            return null;
        }
        return toCreateUserParams(request.getData().getAttributes());
    }

    CreateUserParam toCreateUserParams(CreateUserRequest.Attributes request);
}

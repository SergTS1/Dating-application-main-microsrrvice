package com.date.datingapp.adapter.controller.http.convertor;


import com.date.datingapp.adapter.controller.http.response.CreateUserResponse;
import com.date.datingapp.adapter.controller.http.response.GetUserResponse;
import com.date.datingapp.boundary.model.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    default GetUserResponse toDto(UserInfo result) {
        if (result == null) {
            return null;
        }
        GetUserResponse.Attributes attributes = toGetUserResponse(result);

        GetUserResponse.UserData userData = new GetUserResponse.UserData();
        userData.setId(result.getId());
        userData.setCreatedAt(result.getCreatedAt());
        userData.setAttributes(attributes);

        GetUserResponse response = new GetUserResponse();
        response.setData(userData);

        return response;
    }

    GetUserResponse.Attributes toGetUserResponse(UserInfo result);

    default CreateUserResponse toCreateDto(UserInfo result) {
        if (result == null) {
            return null;
        }
        CreateUserResponse.UserData userData = toCreateUserResponse(result);
        CreateUserResponse response = new CreateUserResponse();
        response.setData(userData);
        return response;
    }

    CreateUserResponse.UserData toCreateUserResponse(UserInfo result);
}

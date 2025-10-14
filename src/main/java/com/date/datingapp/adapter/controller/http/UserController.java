package com.date.datingapp.adapter.controller.http;


import com.date.datingapp.adapter.controller.http.convertor.UserRequestMapper;
import com.date.datingapp.adapter.controller.http.convertor.UserResponseMapper;
import com.date.datingapp.adapter.controller.http.request.CreateUserRequest;
import com.date.datingapp.adapter.controller.http.response.CreateUserResponse;
import com.date.datingapp.adapter.controller.http.response.GetUserResponse;
import com.date.datingapp.boundary.model.CreateUserParam;
import com.date.datingapp.boundary.model.UserInfo;
import com.date.datingapp.boundary.usecase.CreateUserUseCase;
import com.date.datingapp.boundary.usecase.GetUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
@Tag(name = "User", description = "APIs for users")
public class UserController {

    CreateUserUseCase createUserUseCase;
    GetUserUseCase getUserUseCase;
    UserRequestMapper requestMapper;
    UserResponseMapper responseMapper;

    @Operation(summary = "Create a new user", description = "Creates a new user with the provided details.")
    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        CreateUserParam params = requestMapper.toParam(request);
        UserInfo userInfo = createUserUseCase.create(params);
        CreateUserResponse getUserResponse = responseMapper.toCreateDto(userInfo);
        return ResponseEntity.ok(getUserResponse);
    }

    @Operation(summary = "Get user by ID", description = "Retrieves user information by user ID.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<GetUserResponse> getUserById(@PathVariable Long id) {
        UserInfo userInfo = getUserUseCase.getUserById(id);
        GetUserResponse getUserResponse = responseMapper.toDto(userInfo);
        return ResponseEntity.ok(getUserResponse);

    }

}

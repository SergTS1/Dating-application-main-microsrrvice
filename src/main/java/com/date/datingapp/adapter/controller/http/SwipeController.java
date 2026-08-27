package com.date.datingapp.adapter.controller.http;

import com.date.datingapp.adapter.controller.http.convertor.swipe.SwipeRequestMapper;
import com.date.datingapp.adapter.controller.http.convertor.swipe.SwipeResponseMapper;
import com.date.datingapp.adapter.controller.http.request.CreateSwipeRequest;
import com.date.datingapp.adapter.controller.http.response.CreateSwipeResponse;
import com.date.datingapp.boundary.model.CreateSwipeParam;
import com.date.datingapp.boundary.usecase.SwipeUseCase;
import com.date.datingapp.domain.valueobject.swipe.SwipeId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@RequestMapping("/api/v1/swipe")
@Tag(name = "Swipe", description = "APIs for swipes")
public class SwipeController {

    SwipeUseCase swipeUseCase;
    SwipeRequestMapper requestMapper;
    SwipeResponseMapper responseMapper;

    @Operation(summary = "Swipe right", description = "Swipe right on a user.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateSwipeResponse swipeRight(@RequestBody CreateSwipeRequest request) {
        CreateSwipeParam params = requestMapper.toParam(request);
        SwipeId swipeId = swipeUseCase.swipeRight(params);
        return responseMapper.toResponse(swipeId.value());
    }
}

package com.date.datingapp.adapter.controller.http.convertor.swipe;

import com.date.datingapp.adapter.controller.http.request.CreateSwipeRequest;
import com.date.datingapp.boundary.model.CreateSwipeParam;
import com.date.datingapp.domain.valueobject.user.UserId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SwipeRequestMapper {

    public CreateSwipeParam toParam(CreateSwipeRequest request) {
        if (request == null || request.getData() == null || request.getData().getAttributes() == null) {
            return null;
        }
        return toCreateSwipeParams(request.getData().getAttributes());
    }

    public CreateSwipeParam toCreateSwipeParams(CreateSwipeRequest.SwipeAttributes attributes) {
        if (attributes == null) {
            return null;
        }

        CreateSwipeParam param = new CreateSwipeParam();
        param.setFrom(UserId.of(UUID.fromString(attributes.getFrom())));
        param.setTo(UserId.of(UUID.fromString(attributes.getTo())));

        return param;
    }
}

package com.date.datingapp.adapter.controller.http.convertor.swipe;


import com.date.datingapp.adapter.controller.http.response.CreateSwipeResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SwipeResponseMapper {

    public CreateSwipeResponse toResponse(UUID swipeId) {
        if (swipeId == null) {
            return null;
        }

        CreateSwipeResponse.SwipeData swipeData = toCreateSwipeResponse(swipeId);
        CreateSwipeResponse response = new CreateSwipeResponse();
        response.setData(swipeData);
        return response;
    }

    public CreateSwipeResponse.SwipeData toCreateSwipeResponse(UUID swipeId) {
        if (swipeId == null) {
            return null;
        }

        CreateSwipeResponse.SwipeData swipeData = new CreateSwipeResponse.SwipeData();
        swipeData.setSwipeId(swipeId);
        return swipeData;
    }
}

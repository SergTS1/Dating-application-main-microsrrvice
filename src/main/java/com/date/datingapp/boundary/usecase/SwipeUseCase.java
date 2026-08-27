package com.date.datingapp.boundary.usecase;

import com.date.datingapp.boundary.model.CreateSwipeParam;
import com.date.datingapp.domain.valueobject.swipe.SwipeId;

public interface SwipeUseCase {

    SwipeId swipeRight(CreateSwipeParam params);
}

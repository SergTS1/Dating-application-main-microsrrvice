package com.date.datingapp.boundary.repository;

import com.date.datingapp.domain.entity.swipe.Swipe;
import com.date.datingapp.domain.enums.SwipeType;
import com.date.datingapp.domain.valueobject.user.UserId;

public interface SwipeRepository {

    void save(Swipe swipe);

    boolean existsLike(UserId from, UserId to, SwipeType type);
}

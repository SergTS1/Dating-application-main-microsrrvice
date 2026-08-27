package com.date.datingapp.boundary.model;

import com.date.datingapp.domain.valueobject.user.UserId;
import lombok.Data;

@Data
public class CreateSwipeParam {

    private UserId from;
    private UserId to;

}

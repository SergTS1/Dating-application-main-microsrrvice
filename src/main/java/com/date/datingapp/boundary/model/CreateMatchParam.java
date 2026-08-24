package com.date.datingapp.boundary.model;

import com.date.datingapp.domain.valueobject.UserId;
import lombok.Data;

@Data
public class CreateMatchParam {

    private UserId userId1;
    private UserId userId2;
}

package com.date.datingapp.adapter.controller.http.convertor;

import com.date.datingapp.adapter.controller.http.request.CreateMatchRequest;
import com.date.datingapp.boundary.model.CreateMatchParam;
import com.date.datingapp.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MatchRequestMapper {

    public CreateMatchParam toParam(CreateMatchRequest request) {
        if (request == null || request.getData() == null || request.getData().getAttributes() == null) {
            return null;
        }
        return toCreateMatchParams(request.getData().getAttributes());
    }

    public CreateMatchParam toCreateMatchParams(CreateMatchRequest.MatchAttributes attributes) {
        if (attributes == null) {
            return null;
        }

        CreateMatchParam param = new CreateMatchParam();
        param.setUserId1(UserId.of(UUID.fromString(attributes.getUser1Uuid())));
        param.setUserId2(UserId.of(UUID.fromString(attributes.getUser2Uuid())));

        return param;
    }
}

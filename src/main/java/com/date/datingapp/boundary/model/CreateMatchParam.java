package com.date.datingapp.boundary.model;

import com.date.datingapp.domain.valueobject.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateMatchParam {

    private UserId userId1;
    private UserId userId2;
}

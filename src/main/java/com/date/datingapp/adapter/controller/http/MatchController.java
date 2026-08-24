package com.date.datingapp.adapter.controller.http;

import com.date.datingapp.adapter.controller.http.convertor.MatchRequestMapper;
import com.date.datingapp.adapter.controller.http.convertor.MatchResponseMapper;
import com.date.datingapp.adapter.controller.http.request.CreateMatchRequest;
import com.date.datingapp.adapter.controller.http.response.CreateMatchResponse;
import com.date.datingapp.boundary.model.CreateMatchParam;
import com.date.datingapp.boundary.usecase.MatchUseCase;
import com.date.datingapp.domain.valueobject.MatchId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@RequestMapping("/api/v1/match")
@Tag(name = "Match", description = "APIs for matches")
public class MatchController {

    MatchUseCase matchUseCase;
    MatchRequestMapper requestMapper;
    MatchResponseMapper responseMapper;

    @Operation(summary = "Create a new match", description = "Creates a new match between two users.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMatchResponse createMatch(@RequestBody CreateMatchRequest request) {
        CreateMatchParam params = requestMapper.toParam(request);
        MatchId matchId = matchUseCase.create(params);
        return responseMapper.toResponse(matchId.value());
    }


    //Закоментирована проверка текущего юзера. что бы неболо возможно сти у левого пользователя удалить мэтч
    @Operation(summary = "Delete match by id", description = "Deletes an existing match by id.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unMatch(@PathVariable MatchId id
 //                                 ,@AuthenticationPrincipal User currentUser
                                                                ) {
        matchUseCase.unMatch(id
 //               , currentUser.getId()
        );
    }
}

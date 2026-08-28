package com.date.datingapp.usecase.swipe;

import com.date.datingapp.boundary.model.CreateMatchParam;
import com.date.datingapp.boundary.model.CreateSwipeParam;
import com.date.datingapp.boundary.repository.SwipeRepository;
import com.date.datingapp.boundary.usecase.MatchUseCase;
import com.date.datingapp.boundary.usecase.SwipeUseCase;
import com.date.datingapp.domain.entity.swipe.Swipe;
import com.date.datingapp.domain.valueobject.swipe.SwipeId;
import com.date.datingapp.usecase.exception.SwipeUseCaseError;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SwipeUseCaseImpl implements SwipeUseCase {

    SwipeRepository swipeRepository;
    MatchUseCase matchUseCase;

    public SwipeUseCaseImpl(SwipeRepository swipeRepository, MatchUseCase matchUseCase) {
        this.swipeRepository = swipeRepository;
        this.matchUseCase = matchUseCase;
    }

    @Override
    public SwipeId swipeRight(CreateSwipeParam params) {
        if (params == null) {
            throw SwipeUseCaseError.paramsAreRequired();
        }

        Swipe swipe = Swipe.create(params.getFrom(), params.getTo());
        swipeRepository.save(swipe);
        if (swipeRepository.existsLike(params.getTo(), params.getFrom(), swipe.getType())) {
            matchUseCase.create(CreateMatchParam.builder()
                    .userId1(params.getFrom())
                    .userId2(params.getTo())
                    .build());
        }

        //далее асинхронно отправляем в сервис нотификаций и сервис чатов
        return swipe.getId();
    }


}

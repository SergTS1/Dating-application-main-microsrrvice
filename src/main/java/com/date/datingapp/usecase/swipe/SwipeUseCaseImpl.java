package com.date.datingapp.usecase.swipe;

import com.date.datingapp.boundary.model.CreateSwipeParam;
import com.date.datingapp.boundary.repository.SwipeRepository;
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

    public SwipeUseCaseImpl(SwipeRepository swipeRepository) {
        this.swipeRepository = swipeRepository;
    }

    @Override
    public SwipeId swipeRight(CreateSwipeParam params) {
        if (params == null) {
            throw SwipeUseCaseError.paramsAreRequired();
        }

        Swipe swipe = Swipe.create(params.getFrom(), params.getTo());
        swipeRepository.save(swipe);
        return swipe.getId();
    }


}

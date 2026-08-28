package com.date.datingapp.adapter.repository.swipe;


import com.date.datingapp.adapter.repository.swipe.converter.SwipeConverter;
import com.date.datingapp.boundary.repository.SwipeRepository;
import com.date.datingapp.domain.entity.swipe.Swipe;
import com.date.datingapp.domain.enums.SwipeType;
import com.date.datingapp.domain.valueobject.user.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SwipeRepositoryImpl  implements SwipeRepository {

    private final SwipeJpaRepository swipeJpaRepository;
    private final SwipeConverter swipeConverter;

    @Override
    public void save(Swipe swipe) {
        swipeJpaRepository.save(swipeConverter.toEntity(swipe));
    }

    @Override
    public boolean existsLike(UserId from, UserId to, SwipeType type) {
        return swipeJpaRepository.existsByFromAndToAndType(from.value(), to.value(), type);
    }
}

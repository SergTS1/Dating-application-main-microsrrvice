package com.date.datingapp.usecase.match;

import com.date.datingapp.boundary.model.CreateMatchParam;
import com.date.datingapp.boundary.repository.MatchRepository;
import com.date.datingapp.boundary.usecase.MatchUseCase;
import com.date.datingapp.domain.entity.match.Match;
import com.date.datingapp.domain.valueobject.MatchId;
import com.date.datingapp.usecase.exception.MatchUseCaseError;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MatchUseCaseImpl implements MatchUseCase {

    MatchRepository matchRepository;

    public MatchUseCaseImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public MatchId create(CreateMatchParam matchParam) {

        if (matchParam == null) {
            throw MatchUseCaseError.paramsAreRequired();
        }

        Match match = Match.create(matchParam.getUserId1(), matchParam.getUserId2());
        matchRepository.save(match);
        return match.getId();
    }

    @Override
    public void unMatch(MatchId matchId) {
        if (matchId == null) {
            throw MatchUseCaseError.paramsAreRequired();
        }
        Match match = matchRepository.findById(matchId.value())
                .orElseThrow(() -> MatchUseCaseError.matchNotFound(matchId.value()));

        // тут нужно передавать именно текущего пользователя, пока не понятно какой из них текущий
        match.unMatch(match.getUserA());
        matchRepository.save(match);

        // Либо удалять мэтч, либо просто менять статус на "unmatched". Решить позже. Пока оставлю удаление мэтча
        matchRepository.deleteByMatchId(matchId.value());
    }
}

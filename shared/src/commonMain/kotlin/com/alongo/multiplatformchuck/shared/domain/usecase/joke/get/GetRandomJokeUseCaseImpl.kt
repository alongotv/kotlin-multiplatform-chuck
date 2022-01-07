package com.alongo.multiplatformchuck.shared.domain.usecase.joke.get

import com.alongo.multiplatformchuck.shared.data.datasource.network.chuck.jokes.JokesEndpoint
import com.alongo.multiplatformchuck.shared.domain.entity.display.jokes.DisplayJoke
import com.alongo.multiplatformchuck.shared.domain.entity.dto.jokes.JokeDto
import com.alongo.multiplatformchuck.shared.utils.mapper.DtoDisplayMapper

class GetRandomJokeUseCaseImpl(
    private val jokesEndpoint: JokesEndpoint,
    private val jokeDtoDisplayMapper: DtoDisplayMapper<JokeDto, DisplayJoke>
) : GetRandomJokeUseCase {
    override suspend fun invoke(): DisplayJoke {
        return jokeDtoDisplayMapper.fromDtoToDisplay(jokesEndpoint.getRandomJoke())
    }
}

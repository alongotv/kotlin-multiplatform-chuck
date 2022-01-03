package com.alongo.multiplatformchuck.shared.domain.usecase.joke.get

import com.alongo.multiplatformchuck.shared.data.datasource.network.jokes.JokesEndpoint
import com.alongo.multiplatformchuck.shared.domain.entity.dto.jokes.JokeDto

class GetRandomJokeUseCaseImpl(private val jokesEndpoint: JokesEndpoint) : GetRandomJokeUseCase {
    override suspend fun invoke(): JokeDto {
        return jokesEndpoint.getRandomJoke()
    }
}

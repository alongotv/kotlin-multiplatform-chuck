package com.alongo.multiplatformchuck.shared.domain.usecase.joke.get

import com.alongo.multiplatformchuck.shared.domain.entity.display.jokes.DisplayJoke

interface GetRandomJokeUseCase {
    suspend operator fun invoke(): DisplayJoke
}

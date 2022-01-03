package com.alongo.multiplatformchuck.shared.domain.usecase.joke.get

import com.alongo.multiplatformchuck.shared.domain.entity.dto.jokes.JokeDto

interface GetRandomJokeUseCase {
    suspend operator fun invoke(): JokeDto
}

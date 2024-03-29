package com.alongo.multiplatformchuck.shared.data.datasource.network.chuck.jokes

import com.alongo.multiplatformchuck.shared.domain.entity.dto.jokes.JokeDto

interface JokesEndpoint {
    suspend fun getRandomJoke(): JokeDto
}

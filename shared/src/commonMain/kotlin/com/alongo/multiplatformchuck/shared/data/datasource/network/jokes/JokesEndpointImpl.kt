package com.alongo.multiplatformchuck.shared.data.datasource.network.jokes

import com.alongo.multiplatformchuck.shared.data.datasource.network.ChuckNorrisApi
import com.alongo.multiplatformchuck.shared.domain.entity.dto.jokes.JokeDto

class JokesEndpointImpl : ChuckNorrisApi(), JokesEndpoint {

    override suspend fun getRandomJoke(): JokeDto {
        return get("/jokes/random")
    }
}

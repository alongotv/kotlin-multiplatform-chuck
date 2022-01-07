package com.alongo.multiplatformchuck.shared.data.datasource.network.chuck.jokes

import com.alongo.multiplatformchuck.shared.common.dispatchers.DispatcherProvider
import com.alongo.multiplatformchuck.shared.data.datasource.network.chuck.ChuckNorrisApi
import com.alongo.multiplatformchuck.shared.domain.entity.dto.jokes.JokeDto

class JokesEndpointImpl(dispatcherProvider: DispatcherProvider) : ChuckNorrisApi(dispatcherProvider),
    JokesEndpoint {

    override suspend fun getRandomJoke(): JokeDto {
        return get("/jokes/random")
    }
}

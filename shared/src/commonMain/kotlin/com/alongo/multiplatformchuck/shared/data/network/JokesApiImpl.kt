package com.alongo.multiplatformchuck.shared.data.network

import com.alongo.multiplatformchuck.shared.domain.entity.httpentities.jokes.Joke
import io.ktor.client.*
import io.ktor.client.request.*

class JokesApiImpl(private val httpClient: HttpClient) : ChuckNorrisJokesApi {

    override suspend fun getRandomJoke(): Joke {
        return httpClient.get(endpoint + "/random")
    }
}
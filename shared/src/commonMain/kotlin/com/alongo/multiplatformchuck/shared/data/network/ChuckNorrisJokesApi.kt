package com.alongo.multiplatformchuck.shared.data.network

import com.alongo.multiplatformchuck.shared.data.network.base.BaseChuckNorrisApi
import com.alongo.multiplatformchuck.shared.domain.entity.httpentities.response.GetRandomJokesResponse

interface ChuckNorrisJokesApi : BaseChuckNorrisApi {
    override val secondaryUrl: String
        get() = "/jokes"

    suspend fun getRandomJoke(): GetRandomJokesResponse

}



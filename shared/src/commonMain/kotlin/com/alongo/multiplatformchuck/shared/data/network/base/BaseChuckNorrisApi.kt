package com.alongo.multiplatformchuck.shared.data.network.base

interface BaseChuckNorrisApi : BaseApi {
    override val baseUrl: String
        get() = "https://api.chucknorris.io"

}

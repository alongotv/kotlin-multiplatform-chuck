package com.alongo.multiplatformchuck.shared.data.network

import com.alongo.multiplatformchuck.shared.data.network.base.BaseApi

open class ChuckNorrisApi: BaseApi() {
    override val baseUrl: String
        get() = "https://api.chucknorris.io"
}

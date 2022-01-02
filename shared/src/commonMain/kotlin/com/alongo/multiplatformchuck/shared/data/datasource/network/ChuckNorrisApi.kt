package com.alongo.multiplatformchuck.shared.data.datasource.network

import com.alongo.multiplatformchuck.shared.data.datasource.network.base.BaseApi

open class ChuckNorrisApi: BaseApi() {
    override val baseUrl: String
        get() = "https://api.chucknorris.io"
}

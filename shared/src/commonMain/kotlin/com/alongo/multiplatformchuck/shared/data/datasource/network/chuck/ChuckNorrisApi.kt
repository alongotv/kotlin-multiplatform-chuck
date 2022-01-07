package com.alongo.multiplatformchuck.shared.data.datasource.network.chuck

import com.alongo.multiplatformchuck.shared.common.dispatchers.DispatcherProvider
import com.alongo.multiplatformchuck.shared.data.datasource.network.base.BaseApi

open class ChuckNorrisApi(dispatcherProvider: DispatcherProvider) : BaseApi(dispatcherProvider) {
    override val baseUrl: String
        get() = "https://api.chucknorris.io"
}

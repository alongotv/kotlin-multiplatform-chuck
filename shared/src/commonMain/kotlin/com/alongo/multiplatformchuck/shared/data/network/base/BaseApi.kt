package com.alongo.multiplatformchuck.shared.data.network.base


interface BaseApi {
    val baseUrl: String
    val secondaryUrl: String

    val endpoint: String
        get() = baseUrl + secondaryUrl
}
package com.alongo.multiplatformchuck.shared.data.network.base

import com.alongo.multiplatformchuck.shared.di.Injector
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.http.Url
import org.kodein.di.instance

abstract class BaseApi {

    abstract val baseUrl: String
    val httpClient: HttpClient by Injector.kodeinContainer.instance()

    suspend inline fun <reified T : Any> get(
        endpoint: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ): T =
        httpClient.get(url = Url(baseUrl + endpoint), block = block)

    suspend inline fun <reified T : Any> post(
        endpoint: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ): T = httpClient.post(url = Url(baseUrl + endpoint), block = block)
}

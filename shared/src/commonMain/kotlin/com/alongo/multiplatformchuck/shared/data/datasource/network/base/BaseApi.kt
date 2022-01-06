package com.alongo.multiplatformchuck.shared.data.datasource.network.base

import com.alongo.multiplatformchuck.shared.common.dispatchers.DispatcherProvider
import com.alongo.multiplatformchuck.shared.di.Injector
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.http.Url
import kotlinx.coroutines.withContext
import org.kodein.di.instance

abstract class BaseApi(val dispatcherProvider: DispatcherProvider) {

    abstract val baseUrl: String
    val httpClient: HttpClient by Injector.kodeinContainer.instance()

    suspend inline fun <reified T : Any> get(
        endpoint: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): T = withContext(dispatcherProvider.io()) {
        httpClient.get(
            url = Url(baseUrl + endpoint),
            block = block
        )
    }

    suspend inline fun <reified T : Any> post(
        endpoint: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): T = withContext(dispatcherProvider.io()) {
        httpClient.post(
            url = Url(baseUrl + endpoint),
            block = block
        )
    }
}

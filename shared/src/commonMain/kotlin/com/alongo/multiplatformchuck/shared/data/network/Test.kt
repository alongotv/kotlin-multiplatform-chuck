package com.alongo.multiplatformchuck.shared.data.network

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

interface AnswerService {
    fun getAnswers()
}


abstract class CallableApi(val httpClient: HttpClient) {

    suspend fun abstractGet(): Unit {
        val req = HttpRequestBuilder() BODY 2 PATH ""
        return httpClient GET (req BODY {} PATH "") //BODY {} PATH ""
    }

}

fun HttpClient.request() = HttpRequestBuilder()

suspend inline infix fun <reified T> HttpClient.GET(path: String): T {
    return this.get(path)
}

suspend inline infix fun <reified T> HttpClient.GET(builder: HttpRequestBuilder): T {
    return this.get(builder)
}

inline infix fun HttpRequestBuilder.PATH(path: String): HttpRequestBuilder {
    this.url.takeFrom(path)
    return this
}

inline infix fun HttpRequestBuilder.BODY(builder: Any): HttpRequestBuilder {
    this.body = builder
    return this
}

suspend inline infix fun <reified T> HttpClient.PATCH(path: String): T {
    return this.patch(path)
}

suspend inline infix fun <reified T> HttpClient.POST(path: String): T {
    return this.post(path)
}

suspend inline infix fun <reified T> HttpClient.PUT(path: String): T {
    return this.put(path)
}

suspend inline infix fun <reified T> HttpClient.DELETE(path: String): T {
    return this.delete(path)
}
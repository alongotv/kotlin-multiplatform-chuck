package com.alongo.multiplatformchuck.shared.data.network

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

inline infix fun HttpRequestBuilder.PATH(path: String): HttpRequestBuilder {
    this.url.takeFrom(path)
    return this
}

inline infix fun HttpRequestBuilder.BODY(builder: Any): HttpRequestBuilder {
    this.body = builder
    return this
}

inline infix fun HttpRequestBuilder.HEADER(header: Pair<String, String>): HttpRequestBuilder {
    this.header(header.first, header.second)
    return this
}

inline infix fun HttpRequestBuilder.HEADERS(headers: Map<String, String>): HttpRequestBuilder {
    headers.forEach {
        this.headers[it.key] = it.value
    }
    return this
}

suspend inline infix fun <reified T> HttpClient.GET(path: String): T = this.get(path)
suspend inline infix fun <reified T> HttpClient.GET(builder: HttpRequestBuilder): T = this.get(builder)
suspend inline infix fun <reified T> HttpClient.GET(block: HttpRequestBuilder.() -> Unit): T =
    this.request {
        this.method = HttpMethod.Get
        apply(block)
    }

suspend inline infix fun <reified T> HttpClient.POST(path: String): T = this.post(path)
suspend inline infix fun <reified T> HttpClient.POST(builder: HttpRequestBuilder): T = this.post(builder)
suspend inline infix fun <reified T> HttpClient.POST(block: HttpRequestBuilder.() -> Unit): T =
    this.request {
        this.method = HttpMethod.Post
        apply(block)
    }

suspend inline infix fun <reified T> HttpClient.PUT(path: String): T = this.put(path)
suspend inline infix fun <reified T> HttpClient.PUT(builder: HttpRequestBuilder): T = this.put(builder)
suspend inline infix fun <reified T> HttpClient.PUT(block: HttpRequestBuilder.() -> Unit): T =
    this.request {
        this.method = HttpMethod.Put
        apply(block)
    }

suspend inline infix fun <reified T> HttpClient.PATCH(path: String): T = this.patch(path)
suspend inline infix fun <reified T> HttpClient.PATCH(builder: HttpRequestBuilder): T = this.patch(builder)
suspend inline infix fun <reified T> HttpClient.PATCH(block: HttpRequestBuilder.() -> Unit): T =
    this.request {
        this.method = HttpMethod.Patch
        apply(block)
    }

suspend inline infix fun <reified T> HttpClient.DELETE(path: String): T = this.delete(path)
suspend inline infix fun <reified T> HttpClient.DELETE(builder: HttpRequestBuilder): T = this.delete(builder)
suspend inline infix fun <reified T> HttpClient.DELETE(block: HttpRequestBuilder.() -> Unit): T =
    this.request {
        this.method = HttpMethod.Delete
        apply(block)
    }

suspend inline infix fun <reified T> HttpClient.HEAD(path: String): T = this.head(path)
suspend inline infix fun <reified T> HttpClient.HEAD(builder: HttpRequestBuilder): T = this.head(builder)
suspend inline infix fun <reified T> HttpClient.HEAD(block: HttpRequestBuilder.() -> Unit): T =
    this.request {
        this.method = HttpMethod.Head
        apply(block)
    }

suspend inline infix fun <reified T> HttpClient.OPTIONS(path: String): T = this.options(path)
suspend inline infix fun <reified T> HttpClient.OPTIONS(builder: HttpRequestBuilder): T = this.options(builder)
suspend inline infix fun <reified T> HttpClient.OPTIONS(block: HttpRequestBuilder.() -> Unit): T =
    this.request {
        this.method = HttpMethod.Options
        apply(block)
    }
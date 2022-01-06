package com.alongo.multiplatformchuck.shared.di.data.datasource.network

import com.alongo.multiplatformchuck.shared.common.KtorClientEngine
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val httpClientModule = DI.Module("HttpClientModule") {
    bind<HttpClient>() with singleton {
        HttpClient(KtorClientEngine.engine) {
            expectSuccess = false
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.v(tag = "HTTP Client", message = message)
                    }
                }
                level = LogLevel.INFO
            }
        }
    }
}

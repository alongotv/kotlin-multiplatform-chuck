package com.alongo.multiplatformchuck.shared.di

import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.engine.cio.CIO
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val dataModule = DI.Module("data") {
    bind<HttpClient>() with singleton {
        HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }
    }
}


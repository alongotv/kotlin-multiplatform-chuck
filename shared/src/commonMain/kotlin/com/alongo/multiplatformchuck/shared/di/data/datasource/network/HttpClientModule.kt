package com.alongo.multiplatformchuck.shared.di.data.datasource.network

import com.alongo.multiplatformchuck.shared.common.KtorClientEngine
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
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
        }
    }
}

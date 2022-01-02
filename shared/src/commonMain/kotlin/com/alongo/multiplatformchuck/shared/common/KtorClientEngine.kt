package com.alongo.multiplatformchuck.shared.common

import io.ktor.client.engine.HttpClientEngine

expect object KtorClientEngine {
    val engine: HttpClientEngine
}

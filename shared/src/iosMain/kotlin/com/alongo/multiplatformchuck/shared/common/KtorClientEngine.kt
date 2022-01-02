package com.alongo.multiplatformchuck.shared.common

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*

actual object KtorClientEngine {
    actual val engine: HttpClientEngine
        get() = Ios.create()
}

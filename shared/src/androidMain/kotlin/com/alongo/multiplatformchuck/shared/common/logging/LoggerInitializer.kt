package com.alongo.multiplatformchuck.shared.common.logging

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

actual object LoggerInitializer {
    actual fun initialize() {
        Napier.base(DebugAntilog())
    }
}

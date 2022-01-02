package com.alongo.multiplatformchuck.shared.common.logging

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

object LoggerInitializer {
    fun initialize() {
        Napier.base(DebugAntilog())
    }
}
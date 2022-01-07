package com.alongo.multiplatformchuck.shared.common

actual object AppConfig {
    actual fun isDebugBuild(): Boolean = Platform.isDebugBinary
}

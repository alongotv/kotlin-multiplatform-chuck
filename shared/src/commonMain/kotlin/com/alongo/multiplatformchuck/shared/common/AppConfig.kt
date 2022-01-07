package com.alongo.multiplatformchuck.shared.common

expect object AppConfig {
    fun isDebugBuild(): Boolean
}
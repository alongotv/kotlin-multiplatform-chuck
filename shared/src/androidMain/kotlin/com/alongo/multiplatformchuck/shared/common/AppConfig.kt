package com.alongo.multiplatformchuck.shared.common

import com.alongo.multiplatformchuck.android.BuildConfig

actual object AppConfig {
    actual fun isDebugBuild(): Boolean = BuildConfig.DEBUG
}

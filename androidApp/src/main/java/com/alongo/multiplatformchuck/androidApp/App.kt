package com.alongo.multiplatformchuck.androidApp

import android.app.Application
import com.alongo.multiplatformchuck.shared.common.logging.LoggerInitializer

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        LoggerInitializer.initialize()
    }
}

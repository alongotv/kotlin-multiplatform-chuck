package com.alongo.multiplatformchuck.androidApp

import android.app.Application
import com.alongo.multiplatformchuck.shared.common.logging.LoggerInitializer
import com.alongo.multiplatformchuck.shared.di.androidModule
import com.alongo.multiplatformchuck.shared.di.data.dataModule
import com.alongo.multiplatformchuck.shared.di.domain.domainModule
import com.alongo.multiplatformchuck.shared.di.presentation.presentationModule
import com.alongo.multiplatformchuck.shared.di.utils.utilsModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

class App : Application(), DIAware {
    override fun onCreate() {
        super.onCreate()
        LoggerInitializer.initialize()
    }

    override val di by lazy {
        DI.lazy {
            //FIXME: extension of kodeinContainer does not import dependencies
            //extend(Injector.kodeinContainer)
            import(androidXModule(this@App))
            import(androidModule)
            importAll(
                dataModule, domainModule, presentationModule, utilsModule
            )
        }
    }
}

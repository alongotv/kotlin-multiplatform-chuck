package com.alongo.multiplatformchuck.shared.di

import com.alongo.multiplatformchuck.shared.common.dispatchers.DispatcherProviderFactory
import com.alongo.multiplatformchuck.shared.di.common.dispatchers.dispatcherProviderModule
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val androidModule = DI.Module("AndroidModule") {
    importAll(dispatcherProviderModule)

    bind<DispatcherProviderFactory>() with singleton {
        DispatcherProviderFactory()
    }
}

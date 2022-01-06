package com.alongo.multiplatformchuck.shared.di

import com.alongo.multiplatformchuck.shared.common.dispatchers.DispatcherProviderFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val iosModule = DI.Module("IosModule") {
    bind<DispatcherProviderFactory>() with singleton {
        DispatcherProviderFactory()
    }
}
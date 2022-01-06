package com.alongo.multiplatformchuck.shared.di.common.dispatchers

import com.alongo.multiplatformchuck.shared.common.dispatchers.DispatcherProvider
import com.alongo.multiplatformchuck.shared.common.dispatchers.DispatcherProviderFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val dispatcherProviderModule = DI.Module("DispatcherProviderModule") {
    bind<DispatcherProvider>("Default") with singleton {
        instance<DispatcherProviderFactory>().createDispatcherProvider()
    }
}

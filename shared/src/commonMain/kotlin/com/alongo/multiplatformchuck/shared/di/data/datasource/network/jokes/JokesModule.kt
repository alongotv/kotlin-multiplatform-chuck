package com.alongo.multiplatformchuck.shared.di.data.datasource.network.jokes

import com.alongo.multiplatformchuck.shared.data.datasource.network.chuck.jokes.JokesEndpoint
import com.alongo.multiplatformchuck.shared.data.datasource.network.chuck.jokes.JokesEndpointImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val jokesModule = DI.Module("JokesModule") {
    bind<JokesEndpoint>() with singleton {
        JokesEndpointImpl(dispatcherProvider = instance())
    }
}

package com.alongo.multiplatformchuck.shared.di

import com.alongo.multiplatformchuck.shared.data.network.ChuckNorrisJokesApi
import com.alongo.multiplatformchuck.shared.domain.network.JokesApiImpl
import org.kodein.di.*

val domainModule = DI.Module("domain") {
    bind<ChuckNorrisJokesApi>() with provider {
        JokesApiImpl(instance())
    }
}
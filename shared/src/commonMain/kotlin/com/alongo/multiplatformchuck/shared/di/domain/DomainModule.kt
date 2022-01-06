package com.alongo.multiplatformchuck.shared.di.domain

import com.alongo.multiplatformchuck.shared.di.domain.usecase.joke.get.getRandomJokeUseCaseModule
import org.kodein.di.DI

val domainModule = DI.Module("DomainModule") {
    import(getRandomJokeUseCaseModule)
}

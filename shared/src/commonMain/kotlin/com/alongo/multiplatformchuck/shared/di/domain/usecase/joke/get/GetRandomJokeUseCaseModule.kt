package com.alongo.multiplatformchuck.shared.di.domain.usecase.joke.get

import com.alongo.multiplatformchuck.shared.domain.usecase.joke.get.GetRandomJokeUseCase
import com.alongo.multiplatformchuck.shared.domain.usecase.joke.get.GetRandomJokeUseCaseImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val getRandomJokeUseCaseModule = DI.Module("GetRandomJokeUseCaseModule") {
    bind<GetRandomJokeUseCase>() with singleton {
        GetRandomJokeUseCaseImpl(instance(), instance())
    }
}

package com.alongo.multiplatformchuck.shared.di.presentation.main

import com.alongo.multiplatformchuck.shared.presentation.main.MainViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val mainViewModelModule = DI.Module("MainViewModelModule") {
    bind<MainViewModel>() with singleton {
        MainViewModel(instance("Default"), instance())
    }
}

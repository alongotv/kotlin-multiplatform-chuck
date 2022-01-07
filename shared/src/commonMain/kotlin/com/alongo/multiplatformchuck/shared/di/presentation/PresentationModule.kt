package com.alongo.multiplatformchuck.shared.di.presentation

import com.alongo.multiplatformchuck.shared.di.presentation.main.mainViewModelModule
import org.kodein.di.DI

val presentationModule = DI.Module("PresentationModule") {
    import(mainViewModelModule)
    import(colorFromStringFactoryModule)
}
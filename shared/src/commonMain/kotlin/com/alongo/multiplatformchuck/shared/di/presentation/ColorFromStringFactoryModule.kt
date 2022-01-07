package com.alongo.multiplatformchuck.shared.di.presentation

import com.alongo.multiplatformchuck.shared.presentation.ColorFromStringFactory
import com.alongo.multiplatformchuck.shared.presentation.RgbColorValueFromStringFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val colorFromStringFactoryModule = DI.Module("ColorFromStringFactoryModule") {
    bind<ColorFromStringFactory>() with singleton {
        RgbColorValueFromStringFactory()
    }
}

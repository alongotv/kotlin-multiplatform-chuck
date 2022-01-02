package com.alongo.multiplatformchuck.shared.di

import com.alongo.multiplatformchuck.shared.di.data.dataModule
import org.kodein.di.DI

object Injector {
    val kodeinContainer = DI.lazy { importAll(dataModule) }
}

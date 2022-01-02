package com.alongo.multiplatformchuck.shared.di

import com.alongo.multiplatformchuck.shared.di.data.dataModule
import com.alongo.multiplatformchuck.shared.di.domain.domainModule
import org.kodein.di.DI

object Injector {
    val kodeinContainer = DI.lazy { importAll(domainModule, dataModule) }
}

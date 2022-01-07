package com.alongo.multiplatformchuck.shared.di

import com.alongo.multiplatformchuck.shared.di.common.dispatchers.dispatcherProviderModule
import com.alongo.multiplatformchuck.shared.di.data.dataModule
import com.alongo.multiplatformchuck.shared.di.domain.domainModule
import com.alongo.multiplatformchuck.shared.di.presentation.presentationModule
import com.alongo.multiplatformchuck.shared.di.utils.utilsModule
import org.kodein.di.DI

object Injector {
    val kodeinContainer =
        DI.lazy {
            importAll(
                dataModule,
                domainModule,
                presentationModule,
                dispatcherProviderModule,
                utilsModule
            )
        }
}

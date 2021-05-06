package com.alongo.multiplatformchuck.shared.di

import org.kodein.di.DI

val kodein = DI {
    import(dataModule)
    import(domainModule)
}
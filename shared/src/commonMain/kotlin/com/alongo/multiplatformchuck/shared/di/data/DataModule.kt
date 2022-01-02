package com.alongo.multiplatformchuck.shared.di.data

import com.alongo.multiplatformchuck.shared.di.data.datasource.network.httpClientModule
import com.alongo.multiplatformchuck.shared.di.data.datasource.network.jokes.jokesModule
import org.kodein.di.DI

val dataModule = DI.Module("KtorModule") {

    import(httpClientModule)

    importAll(jokesModule)
}

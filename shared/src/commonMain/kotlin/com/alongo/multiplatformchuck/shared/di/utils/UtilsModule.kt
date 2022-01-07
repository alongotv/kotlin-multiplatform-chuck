package com.alongo.multiplatformchuck.shared.di.utils

import com.alongo.multiplatformchuck.shared.di.utils.mapper.jokeDtoDisplayMapperModule
import org.kodein.di.DI

val utilsModule = DI.Module("UtilsModule") {
    import(jokeDtoDisplayMapperModule)
}

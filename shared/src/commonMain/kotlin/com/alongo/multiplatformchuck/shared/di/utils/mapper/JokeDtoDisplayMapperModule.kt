package com.alongo.multiplatformchuck.shared.di.utils.mapper

import com.alongo.multiplatformchuck.shared.domain.entity.display.jokes.DisplayJoke
import com.alongo.multiplatformchuck.shared.domain.entity.dto.jokes.JokeDto
import com.alongo.multiplatformchuck.shared.utils.mapper.DtoDisplayMapper
import com.alongo.multiplatformchuck.shared.utils.mapper.joke.JokeDtoDisplayMapper
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val jokeDtoDisplayMapperModule = DI.Module("JokeDtoDisplayMapperModule") {
    bind<DtoDisplayMapper<JokeDto, DisplayJoke>>() with singleton {
        JokeDtoDisplayMapper(instance())
    }
}

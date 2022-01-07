package com.alongo.multiplatformchuck.shared.utils.mapper.joke

import com.alongo.multiplatformchuck.shared.domain.entity.display.jokes.DisplayJoke
import com.alongo.multiplatformchuck.shared.domain.entity.dto.jokes.JokeDto
import com.alongo.multiplatformchuck.shared.presentation.ColorFromStringFactory
import com.alongo.multiplatformchuck.shared.presentation.MultiplatformColor
import com.alongo.multiplatformchuck.shared.utils.mapper.DtoDisplayMapper

class JokeDtoDisplayMapper(private val colorFromStringFactory: ColorFromStringFactory) :
    DtoDisplayMapper<JokeDto, DisplayJoke>() {
    override fun fromDtoToDisplay(dto: JokeDto) =
        DisplayJoke(
            jokeText = dto.value,
            jokeBackgroundColor =
            dto.id.run {
                val arrays = this.chunked(3).filter { it.length >= 3 }
                MultiplatformColor(
                    r = dto.id.run {
                        val colorHashString = arrays.getOrElse(0) { "" }
                        colorFromStringFactory.generateColorForStringValue(colorHashString)
                    },
                    g = dto.id.run {
                        val colorHashString = arrays.getOrElse(1) { "" }
                        colorFromStringFactory.generateColorForStringValue(colorHashString)
                    },
                    b = dto.id.run {
                        val colorHashString = arrays.getOrElse(2) { "" }
                        colorFromStringFactory.generateColorForStringValue(colorHashString)
                    }
                )
            }
        )
}

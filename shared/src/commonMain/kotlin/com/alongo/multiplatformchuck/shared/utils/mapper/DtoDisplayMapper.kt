package com.alongo.multiplatformchuck.shared.utils.mapper

import com.alongo.multiplatformchuck.shared.domain.entity.display.Display
import com.alongo.multiplatformchuck.shared.domain.entity.dto.Dto

abstract class DtoDisplayMapper<I : Dto, M : Display> {
    abstract fun fromDtoToDisplay(dto: I): M
    fun fromDisplayToDto(display: M): I =
        throw NotImplementedError("DtoDisplayMapper fromDisplayToDto not implemented")
}

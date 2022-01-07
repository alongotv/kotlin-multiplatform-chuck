package com.alongo.multiplatformchuck.shared.domain.entity.display.jokes

import com.alongo.multiplatformchuck.shared.domain.entity.display.Display
import com.alongo.multiplatformchuck.shared.presentation.MultiplatformColor

data class DisplayJoke(
    val jokeText: String,
    val jokeBackgroundColor: MultiplatformColor
) : Display

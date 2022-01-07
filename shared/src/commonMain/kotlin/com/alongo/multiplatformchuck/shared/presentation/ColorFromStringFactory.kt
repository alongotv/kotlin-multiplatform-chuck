package com.alongo.multiplatformchuck.shared.presentation

abstract class ColorFromStringFactory {
    abstract fun generateColorForStringValue(value: String): Double
}

package com.alongo.multiplatformchuck.shared.presentation

class RgbColorValueFromStringFactory : ColorFromStringFactory() {
    override fun generateColorForStringValue(value: String): Double {
        return value.hashCode().rem(255.0)
    }
}

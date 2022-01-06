package com.alongo.multiplatformchuck.shared.common.dispatchers

expect class DispatcherProviderFactory {
    fun createDispatcherProvider(): DispatcherProvider
}

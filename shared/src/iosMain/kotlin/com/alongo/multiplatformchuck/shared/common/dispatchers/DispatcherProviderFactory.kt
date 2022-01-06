package com.alongo.multiplatformchuck.shared.common.dispatchers

actual class DispatcherProviderFactory {
    actual fun createDispatcherProvider(): DispatcherProvider = NativeDispatcherProvider()
}

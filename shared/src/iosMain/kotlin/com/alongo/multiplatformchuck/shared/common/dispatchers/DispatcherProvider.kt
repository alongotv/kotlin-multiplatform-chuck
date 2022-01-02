package com.alongo.multiplatformchuck.shared.common.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

actual interface DispatcherProvider {
    actual fun io(): CoroutineDispatcher
    actual fun immediate(): CoroutineDispatcher
    actual fun default(): CoroutineDispatcher
    actual fun unconfined(): CoroutineDispatcher
    actual fun main(): CoroutineDispatcher
}
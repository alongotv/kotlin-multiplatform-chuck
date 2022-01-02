package com.alongo.multiplatformchuck.shared.common.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

expect interface DispatcherProvider {
    fun io(): CoroutineDispatcher
    fun immediate(): CoroutineDispatcher
    fun default(): CoroutineDispatcher
    fun unconfined(): CoroutineDispatcher
    fun main(): CoroutineDispatcher
}

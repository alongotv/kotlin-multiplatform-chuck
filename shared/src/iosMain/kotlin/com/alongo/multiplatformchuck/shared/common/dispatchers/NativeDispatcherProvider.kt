package com.alongo.multiplatformchuck.shared.common.dispatchers

import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class NativeDispatcherProvider: DispatcherProvider {

    override fun io(): CoroutineDispatcher {
        Napier.w("IO dispatcher is not available on iOS platform, using Default")
        return Dispatchers.Default
    }

    override fun immediate(): CoroutineDispatcher {
        Napier.w("Immediate dispatcher is not available on iOS platform, using Main")
        return Dispatchers.Main
    }

    override fun default(): CoroutineDispatcher = Dispatchers.Default
    override fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
    override fun main(): CoroutineDispatcher = Dispatchers.Main
}

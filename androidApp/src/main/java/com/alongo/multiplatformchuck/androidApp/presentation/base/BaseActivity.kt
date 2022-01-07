package com.alongo.multiplatformchuck.androidApp.presentation.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import org.kodein.di.DI
import org.kodein.di.DIAware

open class BaseActivity : AppCompatActivity(), DIAware {
    override lateinit var di: DI
    protected val activityScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        di = (applicationContext as DIAware).di
    }

    override fun onPause() {
        super.onPause()
        activityScope.coroutineContext.cancelChildren()
    }
}

package com.alongo.multiplatformchuck.androidApp.presentation.base

import androidx.appcompat.app.AppCompatActivity
import com.alongo.multiplatformchuck.shared.di.Injector
import org.kodein.di.DIAware

open class BaseActivity : AppCompatActivity(), DIAware {

    override val di by lazy {
        Injector.kodeinContainer
    }
}
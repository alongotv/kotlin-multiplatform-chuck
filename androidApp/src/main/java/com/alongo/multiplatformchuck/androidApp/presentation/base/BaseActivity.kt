package com.alongo.multiplatformchuck.androidApp.presentation.base

import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI

open class BaseActivity : AppCompatActivity(), DIAware {

    override val di by closestDI()
}
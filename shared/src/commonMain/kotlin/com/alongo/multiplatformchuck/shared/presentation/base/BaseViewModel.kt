package com.alongo.multiplatformchuck.shared.presentation.base

import com.alongo.multiplatformchuck.shared.common.dispatchers.DispatcherProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel(val dispatchers: DispatcherProvider) {
    private val _errors = MutableSharedFlow<Throwable>()
    val errors = _errors.asSharedFlow()

    protected val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        CoroutineScope(dispatchers.immediate()).launch {
            _errors.emit(throwable)
        }
    }

    protected val viewModelScope =
        CoroutineScope(SupervisorJob() + dispatchers.immediate() + coroutineExceptionHandler)
}

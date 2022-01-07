package com.alongo.multiplatformchuck.shared.presentation.main

import com.alongo.multiplatformchuck.shared.common.dispatchers.DispatcherProvider
import com.alongo.multiplatformchuck.shared.domain.entity.dto.jokes.JokeDto
import com.alongo.multiplatformchuck.shared.domain.usecase.joke.get.GetRandomJokeUseCase
import com.alongo.multiplatformchuck.shared.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    dispatchers: DispatcherProvider,
    private val getRandomJokeUseCase: GetRandomJokeUseCase
): BaseViewModel(dispatchers) {

    private val _jokes = MutableSharedFlow<JokeDto>()
    val jokes = _jokes.asSharedFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun didTapGetRandomJokeButton() {
        getRandomJoke()
    }

    fun getRandomJoke() {
        viewModelScope.launch {
            _isLoading.emit(true)
            val joke = getRandomJokeUseCase()
            _isLoading.emit(false)
            offerJoke(joke)
        }
    }

    private suspend fun offerJoke(joke: JokeDto) {
        _jokes.emit(joke)
    }
}

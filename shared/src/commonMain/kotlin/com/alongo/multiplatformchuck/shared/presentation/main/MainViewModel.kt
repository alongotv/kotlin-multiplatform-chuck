package com.alongo.multiplatformchuck.shared.presentation.main

import com.alongo.multiplatformchuck.shared.common.dispatchers.DispatcherProvider
import com.alongo.multiplatformchuck.shared.domain.entity.display.jokes.DisplayJoke
import com.alongo.multiplatformchuck.shared.domain.entity.dto.jokes.JokeDto
import com.alongo.multiplatformchuck.shared.domain.usecase.joke.get.GetRandomJokeUseCase
import com.alongo.multiplatformchuck.shared.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    dispatchers: DispatcherProvider,
    private val getRandomJokeUseCase: GetRandomJokeUseCase
): BaseViewModel(dispatchers) {

    private val _jokes = MutableStateFlow<DisplayJoke?>(null)
    val jokes = _jokes.asStateFlow().filterNotNull()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        getRandomJoke()
    }

    fun didTapGetRandomJokeButton() {
        getRandomJoke()
    }

    private fun getRandomJoke() {
        viewModelScope.launch {
            _isLoading.emit(true)
            val joke = getRandomJokeUseCase()
            _isLoading.emit(false)
            offerJoke(joke)
        }
    }

    private suspend fun offerJoke(joke: DisplayJoke) {
        _jokes.emit(joke)
    }
}

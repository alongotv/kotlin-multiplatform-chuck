package com.alongo.multiplatformchuck.androidApp.presentation.main

import android.os.Bundle
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alongo.multiplatformchuck.androidApp.R
import com.alongo.multiplatformchuck.androidApp.databinding.ActivityMainBinding
import com.alongo.multiplatformchuck.androidApp.presentation.base.BaseActivity
import com.alongo.multiplatformchuck.androidApp.utils.extensions.setIsVisible
import com.alongo.multiplatformchuck.shared.presentation.main.MainViewModel
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.kodein.di.instance

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by instance()

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getRandomJoke()

        binding.buttonGetRandomJoke.setOnClickListener {
            viewModel.didTapGetRandomJokeButton()
        }
    }

    override fun onResume() {
        super.onResume()
        subscribeToLoadingState()
        subscribeToJokes()
        subscribeToErrors()
    }

    private fun subscribeToLoadingState() {
        activityScope.launch {
            viewModel.isLoading.collect { isLoading ->
                withContext(NonCancellable) {
                    binding.progressBar.setIsVisible(isLoading)
                    binding.textViewJokeText.setIsVisible(!isLoading)
                    binding.buttonGetRandomJoke.isEnabled = !isLoading
                }
            }
        }
    }

    private fun subscribeToJokes() {
        activityScope.launch {
            viewModel.jokes.collect {
                binding.textViewJokeText.text = it.value
            }
        }
    }

    private fun subscribeToErrors() {
        activityScope.launch {
            viewModel.errors.collect {
                Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_LONG).show()
            }
        }
    }
}

package com.alongo.multiplatformchuck.androidApp.presentation.main

import android.os.Bundle
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alongo.multiplatformchuck.androidApp.R
import com.alongo.multiplatformchuck.androidApp.databinding.ActivityMainBinding
import com.alongo.multiplatformchuck.androidApp.presentation.base.BaseActivity
import com.alongo.multiplatformchuck.shared.presentation.main.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.kodein.di.instance

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by instance()

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getRandomJoke()

        binding.buttonGetRandomJoke.setOnClickListener {
            viewModel.getRandomJoke()
        }
    }

    override fun onResume() {
        super.onResume()
        subscribeToJokes()
    }

    private fun subscribeToJokes() {
        activityScope.launch {
            launch {
                viewModel.jokes.collect {
                    binding.textView.text = it.value
                }
            }
            launch {
                viewModel.errors.collect {
                    println("$it")
                    Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

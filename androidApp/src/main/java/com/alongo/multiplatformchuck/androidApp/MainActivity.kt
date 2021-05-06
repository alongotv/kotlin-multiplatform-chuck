package com.alongo.multiplatformchuck.androidApp

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alongo.multiplatformchuck.androidApp.databinding.ActivityMainBinding
import com.alongo.multiplatformchuck.androidApp.presentation.base.BaseActivity
import com.alongo.multiplatformchuck.shared.data.network.ChuckNorrisJokesApi
import com.alongo.multiplatformchuck.shared.di.kodein
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.instance

class MainActivity : BaseActivity() {

    private val jokesApi by kodein.instance<ChuckNorrisJokesApi>()

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadJoke()

        binding.buttonGetRandomJoke.setOnClickListener {
            loadJoke()
        }
    }

    fun loadJoke() {
        CoroutineScope(Dispatchers.IO).launch {
            getJoke()
        }
    }

    suspend fun getJoke()  {
        val response = jokesApi.getRandomJoke()
        println(response.value)

        CoroutineScope(Dispatchers.Main).launch {
            binding.textView.text = response.value
        }

    }
}

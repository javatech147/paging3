package com.example.rickandmortypaging3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmortypaging3.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CharacterViewModel by viewModels()

    val characterListAdapter: CharacterListAdapter by lazy {
        CharacterListAdapter {
            // Navigate to Details screen
            Toast.makeText(this, "${it.name} clicked", Toast.LENGTH_SHORT).show()
        }
    }
    val progressLoaderAdapter: ProgressLoaderAdapter by lazy { ProgressLoaderAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCharacter.adapter = characterListAdapter.withLoadStateHeaderAndFooter(
            header = progressLoaderAdapter,
            footer = progressLoaderAdapter
        )

        viewModel.characters.observe(this) { characters ->
            characterListAdapter.submitData(lifecycle = lifecycle, pagingData = characters)
        }
    }
}

package com.example.rickandmortypaging3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortypaging3.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    characterRepository: CharacterRepository
) : ViewModel() {
    val characters = characterRepository.getCharacters().cachedIn(viewModelScope)
}

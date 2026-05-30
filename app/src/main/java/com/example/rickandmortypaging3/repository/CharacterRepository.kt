package com.example.rickandmortypaging3.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.rickandmortypaging3.paging.CharactersPagingSource
import com.example.rickandmortypaging3.retrofit.ApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(val apiService: ApiService) {

    fun getCharacters() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {
            CharactersPagingSource(apiService = apiService)
        }
    ).liveData
}

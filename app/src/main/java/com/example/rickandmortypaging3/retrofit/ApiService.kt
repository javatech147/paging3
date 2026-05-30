package com.example.rickandmortypaging3.retrofit

import com.example.rickandmortypaging3.model.Characters
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): Characters
}

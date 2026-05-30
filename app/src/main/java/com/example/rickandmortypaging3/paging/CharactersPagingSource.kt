package com.example.rickandmortypaging3.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortypaging3.model.Character
import com.example.rickandmortypaging3.retrofit.ApiService

class CharactersPagingSource(val apiService: ApiService) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getCharacters(page = page)
            LoadResult.Page(
                data = response.characters.orEmpty(),
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (page == response.info.pages) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(anchorPosition = it)?.prevKey?.plus(other = 1)
                ?: state.closestPageToPosition(anchorPosition = it)?.nextKey?.minus(other = 1)
        }
    }
}

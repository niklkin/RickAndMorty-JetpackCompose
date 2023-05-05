package com.example.jetpack_compose.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bersyte.paging3.model.RickMorty
import com.example.jetpack_compose.data.entity.CharacterById
import com.example.recyclerview_advanced.data.api.ApiService

class CharacterPagingSource
constructor(private var apiService: ApiService, private val id: Int) :
    PagingSource<Int, CharacterById>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterById>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, CharacterById> {

        return try {

            val currentPage = params.key ?: 1
            val response = apiService.getCharacterById(id)

            val responseData = mutableListOf<CharacterById>()


            responseData.addAll(listOf(response))

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}
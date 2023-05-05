package com.example.jetpack_compose.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bersyte.paging3.model.RickMorty
import com.example.recyclerview_advanced.data.api.ApiService

class RickAndMortyPagingSource

constructor(private var apiService: ApiService) :
    PagingSource<Int, RickMorty>() {
    override fun getRefreshKey(state: PagingState<Int, RickMorty>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, RickMorty> {

        return try {

            val currentPage = params.key ?: 1
            val response = apiService.getCharacter(currentPage)

            val responseData = mutableListOf<RickMorty>()
            val data = response.body()?.results ?: emptyList()
            Log.d("response", data.toString())
            responseData.addAll(data)

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
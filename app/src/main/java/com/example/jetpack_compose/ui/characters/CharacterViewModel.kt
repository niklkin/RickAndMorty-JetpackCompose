package com.example.jetpack_compose.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.recyclerview_advanced.data.api.ApiService
import com.example.jetpack_compose.data.paging.RickAndMortyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel
@Inject
constructor(
    private val apiService: ApiService
) : ViewModel() {

    fun getCharacters() = Pager(PagingConfig(pageSize = 1, enablePlaceholders = false)) {
        RickAndMortyPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)

}
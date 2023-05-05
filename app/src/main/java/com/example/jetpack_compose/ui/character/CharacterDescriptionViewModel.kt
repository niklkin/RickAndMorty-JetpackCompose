package com.example.jetpack_compose.ui.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_compose.data.entity.CharacterById
import com.example.jetpack_compose.data.entity.Episode
import com.example.recyclerview_advanced.data.api.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDescriptionViewModel
@Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    var character: MutableStateFlow<CharacterById?> = MutableStateFlow(null)

//    var episode: MutableStateFlow<Episode?> = MutableStateFlow(null)


    fun getCharacterById(id: Int) {
        viewModelScope.launch {
            character.value = apiService.getCharacterById(id)
        }

    }

//    fun getEpisodeById(id: Int) {
//        viewModelScope.launch {
//            episode.value = apiService.getEpisodeById(id)
//        }
//
//    }

}
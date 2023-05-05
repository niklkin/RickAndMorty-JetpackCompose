package com.example.jetpack_compose.ui.character

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.jetpack_compose.data.entity.CharacterById

@Composable
fun CharacterDescription(
    id: Int,
    viewModel: CharacterDescriptionViewModel = hiltViewModel()
) {
    viewModel.getCharacterById(id)
    val characterState = viewModel.character.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF313131)
    ) {


        val char = characterState.value

        Surface(
            modifier = Modifier.padding(10.dp),
            color = Color(0xFF525151)
        ) {
            Column(
                modifier = Modifier.padding(5.dp),
            ) {
                if (char != null) {
                    AsyncImage(
                        model = char.image,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Log.d("char", char.toString())
                if (char != null) {
                    CharacterInfo(char = char)
                }

                char?.episode?.let {
                    Episodes(it)
                }
            }
        }


    }
}

@Composable
fun Episodes(
    episodes: List<String>
) {
    Text(
        text = "Episodes:",
        color = Color(0xFF969494)
    )

    LazyColumn() {
        items(items = episodes) {
            Text(
                text = it,
                color = Color.White
            )
        }
    }
}

@Composable
fun CharacterInfo(char: CharacterById) {
    char?.apply {
        Text(
            text = char.name,
            fontSize = 32.sp,
            color = Color.White
        )

        Text(
            text = "Live status:",
            color = Color(0xFF969494)
        )

        Text(
            text = char.status,
            color = Color.White
        )

        Text(
            text = "Species and gender:",
            color = Color(0xFF969494)
        )

        Text(
            text = "${char.species} (${char.gender})",
            color = Color.White
        )
        Text(
            text = "Last known location:",
            color = Color(0xFF969494)
        )

        Text(
            text = char.location.name,
            color = Color.White
        )
        Text(
            text = "First seen in:",
            color = Color(0xFF969494)
        )

        Text(
            text = char.created,
            color = Color.White
        )
    }

}



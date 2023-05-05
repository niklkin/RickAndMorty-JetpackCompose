package com.example.jetpack_compose.ui.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import com.bersyte.paging3.model.RickMorty


@Composable
fun CharacterListScreen(navController: NavController) {
    Surface(
        modifier = Modifier,
        color = Color(0xFF313131),

        ) {
        PagingListScreen(navController = navController)
    }
}


@Composable
fun PagingListScreen(
    viewModel: CharacterViewModel = hiltViewModel(),
    navController: NavController
) {
    val characterList: LazyPagingItems<RickMorty> =
        viewModel.getCharacters().collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier
            .padding(8.dp),

        ) {
        items(items = characterList) {
            if (it != null) {
                CharacterItem(it, navController)
            }
        }
    }
}

@Composable
fun CharacterItem(
    character: RickMorty,
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .padding(8.dp),
        color = Color(0xFF525151)
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate("character_description/" + character.id)
            }) {
            AsyncImage(model = character.image, contentDescription = null)
            Column(Modifier.padding(6.dp)) {
                Text(text = character!!.name, fontSize = 20.sp, color = Color.White)
                Text(text = "${character!!.status} - ${character!!.species}", color = Color.White)
                Text(text = "Last known location:", color = Color(0xFF969494))
                Text(text = character!!.location.name, color = Color.White)
            }

        }
    }

}

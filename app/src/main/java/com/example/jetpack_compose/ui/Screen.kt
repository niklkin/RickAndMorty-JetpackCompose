package com.example.jetpack_compose.ui

sealed class Screen(val route: String) {
    object CharacterList : Screen(route = "character_list_screen")
    object CharacterDescription : Screen(route = "character_description/{id}")
}

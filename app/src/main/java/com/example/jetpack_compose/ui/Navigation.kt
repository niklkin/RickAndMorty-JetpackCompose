package com.example.jetpack_compose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpack_compose.ui.character.CharacterDescription
import com.example.jetpack_compose.ui.characters.CharacterListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    //val viewModel: CharacterViewModel  = viewModel()
    NavHost(
        navController = navController,
        startDestination = "character_list_screen"
    ) {
        composable(
            route = Screen.CharacterList.route
        ) {
            CharacterListScreen(navController = navController)
        }
        composable(
            route = Screen.CharacterDescription.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            CharacterDescription(
                id = it.arguments!!.getInt("id")
            )
        }
    }
}
package com.example.jetpack_compose.data.entity

import com.example.recyclerview_advanced.data.entity.Location


data class CharacterById(

    val created: String,

    val episode: List<String>,

    val gender: String,

    val id: Int,

    val image: String,

    val location: Location,

    val name: String,

    val origin: Origin,

    val species: String,

    val status: String,

    val type: String,

    val url: String
)
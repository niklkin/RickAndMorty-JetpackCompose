package com.bersyte.paging3.model

import com.example.recyclerview_advanced.data.entity.Location


data class RickMorty(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
    val location: Location
)
package com.example.recyclerview_advanced.data.api

import com.bersyte.paging3.model.ResponseApi
import com.example.jetpack_compose.data.entity.CharacterById
import com.example.jetpack_compose.data.entity.Episode
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getCharacter(
        @Query("page") page: Int
    ): Response<ResponseApi>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterById

//    @GET("episode/{url}")
//    suspend fun getEpisodeById(@Path("id") id: Int): Episode
}
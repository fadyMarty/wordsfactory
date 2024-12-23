package com.fadymarty.wordsfactory.data.remote

import com.fadymarty.wordsfactory.domain.model.WordDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("api/v2/entries/en/{word}")
    suspend fun getWord(
        @Path("word") word: String
    ): List<WordDto>

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/"
    }
}
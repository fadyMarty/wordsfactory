package com.fadymarty.wordsfactory.domain.repository

import com.fadymarty.core.Result
import com.fadymarty.wordsfactory.domain.model.WordDto
import com.fadymarty.wordsfactory.wordsfactory.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow

interface WordsRepository {

    fun getWord(word: String): Flow<Result<List<WordDto>>>

    suspend fun upsertWord(word: List<WordEntity>)

    fun getWords(): Flow<List<WordEntity>>
}
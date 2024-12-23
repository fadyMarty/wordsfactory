package com.fadymarty.wordsfactory.wordsfactory.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.fadymarty.wordsfactory.wordsfactory.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {

    @Upsert
    suspend fun upsertWord(word: List<WordEntity>)

    @Query("SELECT * FROM words")
    fun getWords(): Flow<List<WordEntity>>
}
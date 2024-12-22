package com.fadymarty.wordsfactory.domain.repository

import com.fadymarty.core.Result
import com.fadymarty.wordsfactory.domain.model.Word
import kotlinx.coroutines.flow.Flow

interface WordRepository {

    fun getWord(word: String): Flow<Result<List<Word>>>
}
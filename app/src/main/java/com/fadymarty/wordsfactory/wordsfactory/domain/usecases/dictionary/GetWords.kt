package com.fadymarty.wordsfactory.wordsfactory.domain.usecases.dictionary

import com.fadymarty.wordsfactory.wordsfactory.data.local.WordsDao
import com.fadymarty.wordsfactory.wordsfactory.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow

class GetWords(
    private val dao: WordsDao
) {
    operator fun invoke(): Flow<List<WordEntity>> {
        return dao.getWords()
    }
}
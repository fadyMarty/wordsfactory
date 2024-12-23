package com.fadymarty.wordsfactory.wordsfactory.domain.usecases.dictionary

import com.fadymarty.wordsfactory.wordsfactory.data.local.WordsDao
import com.fadymarty.wordsfactory.wordsfactory.data.local.entity.WordEntity

class UpsertWord(
    private val dao: WordsDao
) {
    suspend operator fun invoke(word: List<WordEntity>) {
        dao.upsertWord(word)
    }
}
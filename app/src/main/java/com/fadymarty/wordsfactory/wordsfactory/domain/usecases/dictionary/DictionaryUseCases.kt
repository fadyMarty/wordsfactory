package com.fadymarty.wordsfactory.wordsfactory.domain.usecases.dictionary

import com.fadymarty.wordsfactory.domain.usecases.GetWord

data class DictionaryUseCases(
    val getWord: GetWord,
    val getWords: GetWords,
    val upsertWord: UpsertWord
)
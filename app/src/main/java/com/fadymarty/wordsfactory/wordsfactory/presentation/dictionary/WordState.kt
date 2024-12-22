package com.fadymarty.wordsfactory.presentation.dictionary

import com.fadymarty.wordsfactory.domain.model.Word

data class WordState(
    val wordItems: List<Word> = emptyList(),
    val isDictionaryEmpty: Boolean = true
)
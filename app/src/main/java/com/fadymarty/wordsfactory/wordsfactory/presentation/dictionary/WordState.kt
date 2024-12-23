package com.fadymarty.wordsfactory.presentation.dictionary

import com.fadymarty.wordsfactory.domain.model.WordDto

data class WordState(
    val wordItems: List<WordDto> = emptyList(),
    val isDictionaryEmpty: Boolean = true
)
package com.fadymarty.wordsfactory.domain.model

data class Word(
    val meanings: List<Meaning>,
    val phonetic: String?,
    val phonetics: List<Phonetic>,
    val word: String
)
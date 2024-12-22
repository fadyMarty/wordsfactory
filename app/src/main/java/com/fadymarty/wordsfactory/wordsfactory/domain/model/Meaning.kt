package com.fadymarty.wordsfactory.domain.model

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)
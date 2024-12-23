package com.fadymarty.wordsfactory.domain.model

import com.fadymarty.wordsfactory.wordsfactory.data.local.entity.WordEntity


data class WordDto(
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWordEntity(): WordEntity {
        return WordEntity(
            meanings = meanings.map { it.toMeaning() },
            phonetic = phonetic,
            phonetics = phonetics.map { it.toPhonetic() },
            word = word
        )
    }
}
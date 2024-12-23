package com.fadymarty.wordsfactory.domain.model

import com.fadymarty.wordsfactory.wordsfactory.domain.model.Phonetic

data class PhoneticDto(
    val audio: String,
    val text: String
) {
    fun toPhonetic(): Phonetic {
        return Phonetic(
            audio = audio,
            text = text
        )
    }
}
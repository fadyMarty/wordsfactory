package com.fadymarty.wordsfactory.wordsfactory.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fadymarty.wordsfactory.wordsfactory.domain.model.Meaning
import com.fadymarty.wordsfactory.wordsfactory.domain.model.Phonetic
import com.fadymarty.wordsfactory.wordsfactory.domain.model.Word

@Entity(tableName = "words")
data class WordEntity(
    @PrimaryKey
    val id: Int? = null,
    val meanings: List<Meaning>,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val word: String,
) {
    fun toWord(): Word {
        return Word(
            meanings = meanings,
            phonetic = phonetic,
            phonetics = phonetics,
            word = word
        )
    }
}
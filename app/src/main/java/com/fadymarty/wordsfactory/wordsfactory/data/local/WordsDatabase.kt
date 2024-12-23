package com.fadymarty.wordsfactory.wordsfactory.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fadymarty.wordsfactory.wordsfactory.data.local.entity.WordEntity

@Database(
    entities = [WordEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WordsDatabase: RoomDatabase() {

    abstract val dao: WordsDao
}
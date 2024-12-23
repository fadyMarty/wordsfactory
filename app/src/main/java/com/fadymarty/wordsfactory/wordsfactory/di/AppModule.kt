package com.fadymarty.wordsfactory.di

import android.app.Application
import androidx.room.Room
import com.fadymarty.wordsfactory.data.manager.LocalUserMangerImpl
import com.fadymarty.wordsfactory.data.remote.DictionaryApi
import com.fadymarty.wordsfactory.data.repository.WordsRepositoryImpl
import com.fadymarty.wordsfactory.domain.manager.LocalUserManger
import com.fadymarty.wordsfactory.domain.repository.WordsRepository
import com.fadymarty.wordsfactory.domain.usecases.GetWord
import com.fadymarty.wordsfactory.domain.usecases.app_entry.AppEntryUseCases
import com.fadymarty.wordsfactory.domain.usecases.app_entry.ReadAppEntry
import com.fadymarty.wordsfactory.domain.usecases.app_entry.SaveAppEntry
import com.fadymarty.wordsfactory.wordsfactory.data.local.Converters
import com.fadymarty.wordsfactory.wordsfactory.data.local.WordsDatabase
import com.fadymarty.wordsfactory.wordsfactory.data.util.GsonParser
import com.fadymarty.wordsfactory.wordsfactory.domain.usecases.dictionary.DictionaryUseCases
import com.fadymarty.wordsfactory.wordsfactory.domain.usecases.dictionary.GetWords
import com.fadymarty.wordsfactory.wordsfactory.domain.usecases.dictionary.UpsertWord
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDictionaryUseCase(
        repository: WordsRepository,
        db: WordsDatabase
    ): DictionaryUseCases {
        return DictionaryUseCases(
            getWord = GetWord(repository),
            getWords = GetWords(db.dao),
            upsertWord = UpsertWord(db.dao)
        )
    }

    @Provides
    @Singleton
    fun provideWordRepository(
        api: DictionaryApi,
        db: WordsDatabase,
    ): WordsRepository {
        return WordsRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordsDatabase(app: Application): WordsDatabase {
        return Room.databaseBuilder(
            app, WordsDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application,
    ): LocalUserManger = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger,
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
}


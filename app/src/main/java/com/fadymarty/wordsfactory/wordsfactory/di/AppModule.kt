package com.fadymarty.wordsfactory.di

import android.app.Application
import com.fadymarty.wordsfactory.data.manager.LocalUserMangerImpl
import com.fadymarty.wordsfactory.data.remote.DictionaryApi
import com.fadymarty.wordsfactory.data.repository.WordRepositoryImpl
import com.fadymarty.wordsfactory.domain.manager.LocalUserManger
import com.fadymarty.wordsfactory.domain.repository.WordRepository
import com.fadymarty.wordsfactory.domain.usecases.GetWord
import com.fadymarty.wordsfactory.domain.usecases.app_entry.AppEntryUseCases
import com.fadymarty.wordsfactory.domain.usecases.app_entry.ReadAppEntry
import com.fadymarty.wordsfactory.domain.usecases.app_entry.SaveAppEntry
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
    fun provideGetWordUseCase(repository: WordRepository): GetWord {
        return GetWord(repository)
    }

    @Provides
    @Singleton
    fun provideWordRepository(api: DictionaryApi): WordRepository {
        return WordRepositoryImpl(api)
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


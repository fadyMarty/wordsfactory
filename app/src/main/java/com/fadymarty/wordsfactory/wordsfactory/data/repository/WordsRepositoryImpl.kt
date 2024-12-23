package com.fadymarty.wordsfactory.data.repository

import com.fadymarty.core.Result
import com.fadymarty.wordsfactory.data.remote.DictionaryApi
import com.fadymarty.wordsfactory.domain.model.WordDto
import com.fadymarty.wordsfactory.domain.repository.WordsRepository
import com.fadymarty.wordsfactory.wordsfactory.data.local.WordsDao
import com.fadymarty.wordsfactory.wordsfactory.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class WordsRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordsDao,
) : WordsRepository {

    override fun getWord(word: String): Flow<Result<List<WordDto>>> {

        return flow {

            val wordFromApi = try {
                api.getWord(word)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading word"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading word"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading word"))
                return@flow
            }

            emit(Result.Success(wordFromApi))
        }
    }

    override suspend fun upsertWord(word: List<WordEntity>) {
        dao.upsertWord(word)
    }

    override fun getWords(): Flow<List<WordEntity>> {
        return dao.getWords()
    }
}
package com.fadymarty.wordsfactory.data.repository

import com.fadymarty.wordsfactory.data.remote.DictionaryApi
import com.fadymarty.wordsfactory.domain.model.Word
import com.fadymarty.wordsfactory.domain.repository.WordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import com.fadymarty.core.Result

class WordRepositoryImpl(
    private val api: DictionaryApi
) : WordRepository {
    override fun getWord(word: String): Flow<Result<List<Word>>> {
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
}
package com.fadymarty.wordsfactory.domain.usecases

import com.fadymarty.core.Result
import com.fadymarty.wordsfactory.domain.model.Word
import com.fadymarty.wordsfactory.domain.repository.WordRepository
import kotlinx.coroutines.flow.Flow

class GetWord(
    private val repository: WordRepository,
) {
    operator fun invoke(word: String): Flow<Result<List<Word>>> {
        return repository.getWord(word)
    }
}
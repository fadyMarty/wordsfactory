package com.fadymarty.wordsfactory.domain.usecases

import com.fadymarty.core.Result
import com.fadymarty.wordsfactory.domain.model.WordDto
import com.fadymarty.wordsfactory.domain.repository.WordsRepository
import kotlinx.coroutines.flow.Flow

class GetWord(
    private val repository: WordsRepository,
) {
    operator fun invoke(word: String): Flow<Result<List<WordDto>>> {
        return repository.getWord(word)
    }
}
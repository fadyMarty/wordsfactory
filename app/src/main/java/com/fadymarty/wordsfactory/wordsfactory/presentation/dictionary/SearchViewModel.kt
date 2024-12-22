package com.fadymarty.wordsfactory.presentation.dictionary

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fadymarty.core.Result
import com.fadymarty.wordsfactory.domain.usecases.GetWord
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getWord: GetWord,
) : ViewModel() {

    private val _searchQuery = mutableStateOf<String>("")
    val searchQuery: State<String> = _searchQuery

    private val _wordState = mutableStateOf(WordState())
    val wordState: State<WordState> = _wordState

    fun onValueChange(query: String) {
        _searchQuery.value = query
    }

    fun onSearch(query: String) {
        _searchQuery.value = query

        viewModelScope.launch {
            getWord(query)
                .onEach { result ->
                    when (result) {
                        is Result.Success -> {
                            _wordState.value = wordState.value.copy(
                                wordItems = result.data ?: emptyList(),
                                isDictionaryEmpty = false
                            )
                        }

                        is Result.Error -> {
                            _wordState.value = wordState.value.copy(
                                wordItems = result.data ?: emptyList(),
                                isDictionaryEmpty = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
}
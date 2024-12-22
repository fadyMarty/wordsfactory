package com.fadymarty.wordsfactory.presentation.dictionary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fadymarty.wordsfactory.domain.model.Word
import com.fadymarty.wordsfactory.presentation.common.SearchBar
import com.fadymarty.wordsfactory.presentation.common.WordsButton

@Composable
fun DictionaryScreen(
    viewModel: SearchViewModel,
    wordState: WordState,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchBar(
            modifier = Modifier.padding(
                start = 16.dp,
                top = 24.dp,
                end = 16.dp
            ),
            text = viewModel.searchQuery.value,
            onValueChange = viewModel::onValueChange,
            onSearch = viewModel::onSearch
        )
        Column(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp
                )
        ) {
            if (wordState.wordItems != emptyList<Word>()) {

                val word = wordState.wordItems[0]
                WordInfo(word)

                Spacer(modifier = Modifier.weight(1f))

                WordsButton(
                    modifier = Modifier.padding(
                        start = 24.dp,
                        end = 24.dp,
                        bottom = 8.dp
                    ),
                    text = "Add to Dictionary",
                    onClick = { }
                )
            }
        }
        DictionaryScreen(wordState.isDictionaryEmpty)
    }
}
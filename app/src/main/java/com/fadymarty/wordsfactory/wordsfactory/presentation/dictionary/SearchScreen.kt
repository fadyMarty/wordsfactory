package com.fadymarty.wordsfactory.presentation.dictionary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fadymarty.wordsfactory.presentation.common.SearchBar
import com.fadymarty.wordsfactory.presentation.common.WordsButton

@Composable
fun DictionaryScreen(
    viewModel: SearchViewModel,
    wordState: WordState
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
        LazyColumn(
            Modifier.weight(1f),
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp
            )
        ) {
            items(wordState.wordItems.size) { i ->
                val word = wordState.wordItems[i]
                WordInfo(word)
            }
        }

        DictionaryScreen(wordState.isDictionaryEmpty)

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
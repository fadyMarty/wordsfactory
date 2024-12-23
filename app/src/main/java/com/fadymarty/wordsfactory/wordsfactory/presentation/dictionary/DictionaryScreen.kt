package com.fadymarty.wordsfactory.presentation.dictionary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fadymarty.ui.theme.Rubik
import com.fadymarty.wordsfactory.R
import com.fadymarty.wordsfactory.presentation.common.SearchBar
import com.fadymarty.wordsfactory.presentation.common.WordsButton
import kotlinx.coroutines.launch

@Composable
fun DictionaryScreen(
    viewModel: DictionaryViewModel,
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

        if (wordState.isDictionaryEmpty) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(R.drawable.empty_dictionary),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.padding(32.dp))

                Text(
                    text = "No word",
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Text(
                    text = "Input something to find it in dictionary",
                    fontFamily = Rubik,
                    fontSize = 14.sp,
                    color = colorResource(R.color.dark_gray)
                )
            }
        }

        val coroutineScope = rememberCoroutineScope()

        WordsButton(
            modifier = Modifier.padding(
                start = 24.dp,
                end = 24.dp,
                bottom = 8.dp
            ),
            text = "Add to Dictionary",
            onClick = {

                coroutineScope.launch {
                    viewModel.upsertWord(wordState.wordItems.map { it.toWordEntity() })
                }
            }
        )
    }
}
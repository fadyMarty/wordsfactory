package com.fadymarty.wordsfactory.presentation.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fadymarty.ui.theme.Rubik
import com.fadymarty.ui.theme.WordsFactoryTheme
import com.fadymarty.wordsfactory.R

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    onSearch: (String) -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(modifier = modifier) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(
                    width = 1.dp,
                    color = colorResource(R.color.gray),
                    shape = RoundedCornerShape(12.dp)
                ),
            value = text,
            onValueChange = onValueChange,
            trailingIcon = {
                IconButton(
                    onClick = {
                        onSearch(text)
                        keyboardController?.hide()
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = null,
                        tint = colorResource(R.color.dark),
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch(text)
                    keyboardController?.hide()
                }
            ),
            textStyle = TextStyle(
                fontFamily = Rubik,
                fontSize = 14.sp,
                color = colorResource(R.color.dark)
            ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = MaterialTheme.colorScheme.background
            )
        )
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    WordsFactoryTheme {
        SearchBar(
            text = "Cooking",
            onValueChange = { },
            onSearch = { }
        )
    }
}
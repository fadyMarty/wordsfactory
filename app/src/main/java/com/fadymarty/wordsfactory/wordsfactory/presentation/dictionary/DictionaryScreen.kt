package com.fadymarty.wordsfactory.presentation.dictionary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import java.util.Dictionary

@Composable
fun DictionaryScreen(
    isDictionaryEmpty: Boolean
) {
    if (isDictionaryEmpty) {
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
}
package com.fadymarty.wordsfactory.presentation.onboarding.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fadymarty.ui.theme.Rubik
import com.fadymarty.ui.theme.WordsFactoryTheme
import com.fadymarty.wordsfactory.R
import com.fadymarty.wordsfactory.presentation.onboarding.Page
import com.fadymarty.wordsfactory.presentation.onboarding.pages

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page,
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .height(264.dp),
            painter = painterResource(page.image),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = page.title,
            textAlign = TextAlign.Center,
            fontFamily = Rubik,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = colorResource(R.color.dark)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            text = page.description,
            textAlign = TextAlign.Center,
            fontFamily = Rubik,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = colorResource(R.color.dark_gray)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPagePreview() {
    WordsFactoryTheme {
        OnBoardingPage(
            page = pages[0]
        )
    }
}
package com.fadymarty.wordsfactory.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fadymarty.ui.theme.Rubik
import com.fadymarty.wordsfactory.R
import com.fadymarty.wordsfactory.presentation.common.WordsButton
import com.fadymarty.wordsfactory.presentation.onboarding.components.OnBoardingPage
import com.fadymarty.wordsfactory.presentation.onboarding.components.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    event: (OnBoardingEvent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }
        Row(modifier = Modifier.padding(top = 24.dp, end = 16.dp)) {
            Spacer(Modifier.weight(1f))
            TextButton(
                modifier = Modifier.padding(bottom = 5.dp),
                onClick = {
                    event(OnBoardingEvent.SaveAppEntry)
                }
            ) {
                Text(
                    modifier = Modifier.width(45.dp),
                    text = "Skip",
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.dark_gray),
                    textAlign = TextAlign.End
                )
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }

        Spacer(modifier = Modifier.height(16.dp))

        PageIndicator(
            modifier = Modifier.width(52.dp),
            pageSize = pages.size,
            selectedPage = pagerState.currentPage
        )
        Spacer(modifier = Modifier.weight(1f))

        val scope = rememberCoroutineScope()

        WordsButton(
            modifier = Modifier.padding(
                start = 24.dp,
                end = 24.dp,
                bottom = 24.dp
            ),
            text = "Next",
            onClick = {
                scope.launch {
                    if (pagerState.currentPage == 2) {
                        event(OnBoardingEvent.SaveAppEntry)
                    } else {
                        pagerState.animateScrollToPage(
                            page = pagerState.currentPage + 1
                        )
                    }
                }
            }
        )
    }
}
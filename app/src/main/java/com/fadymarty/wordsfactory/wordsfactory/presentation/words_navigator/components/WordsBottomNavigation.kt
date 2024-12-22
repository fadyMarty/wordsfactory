package com.fadymarty.wordsfactory.presentation.words_navigator.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fadymarty.wordsfactory.R
import com.fadymarty.ui.theme.Rubik
import com.fadymarty.ui.theme.WordsFactoryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WordsBottomNavigation(
    items: List<BottomNavigationItem>,
    selected: Int,
    onItemClick: (Int) -> Unit,
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .border(
                width = 1.dp,
                color = colorResource(R.color.gray),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ),
        containerColor = MaterialTheme.colorScheme.background

    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selected,
                onClick = { onItemClick(index) },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = item.text,
                        fontFamily = Rubik,
                        fontSize = 14.sp
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = colorResource(R.color.gray),
                    unselectedTextColor = colorResource(R.color.gray),
                    indicatorColor = MaterialTheme.colorScheme.background
                )
            )
        }
    }
}

data class BottomNavigationItem(
    @DrawableRes val icon: Int,
    val text: String,
)

@Preview
@Composable
fun NewsBottomNavigationPreview() {
    WordsFactoryTheme {
        WordsBottomNavigation(
            items = listOf(
                BottomNavigationItem(icon = R.drawable.ic_dictionary, text = "Dictionary"),
                BottomNavigationItem(icon = R.drawable.ic_training, text = "Training"),
                BottomNavigationItem(icon = R.drawable.ic_video, text = "Video")
            ),
            selected = 0,
            onItemClick = {}
        )
    }
}
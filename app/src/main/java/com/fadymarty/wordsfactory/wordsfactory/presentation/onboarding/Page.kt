package com.fadymarty.wordsfactory.presentation.onboarding

import androidx.annotation.DrawableRes
import com.fadymarty.wordsfactory.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Learn anytime\nand anywhere",
        description = "Quarantine is the perfect time to spend your\nday learning something new, from anywhere!",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Find a course\nfor you",
        description = "Quarantine is the perfect time to spend your day learning something new, from anywhere!",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "\nImprove your skills",
        description = "Quarantine is the perfect time to spend your day learning something new, from anywhere!",
        image = R.drawable.onboarding3
    )
)
package com.fadymarty.wordsfactory.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fadymarty.ui.theme.Rubik
import com.fadymarty.wordsfactory.R
import com.fadymarty.wordsfactory.domain.model.Definition

@Composable
fun WordCard(
    modifier: Modifier = Modifier,
    definition: Definition
) {
    OutlinedCard(
        modifier = modifier,
        border = BorderStroke(width = 1.dp, color = colorResource(R.color.gray)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = definition.definition,
                fontFamily = Rubik,
                fontSize = 14.sp
            )
            definition.example?.let {
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.secondary)) {
                            append("Example: ")
                        }
                        append(definition.example)
                    },
                    fontFamily = Rubik,
                    fontSize = 14.sp
                )
            }
        }
    }
}
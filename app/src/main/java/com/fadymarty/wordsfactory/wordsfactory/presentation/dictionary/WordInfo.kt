package com.fadymarty.wordsfactory.presentation.dictionary

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fadymarty.ui.theme.Rubik
import com.fadymarty.wordsfactory.R
import com.fadymarty.wordsfactory.domain.model.WordDto
import com.fadymarty.wordsfactory.presentation.common.WordCard
import okio.IOException

@Composable
fun WordInfo(
    word: WordDto,
) {
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = word.word.replaceFirstChar(Char::titlecase),
            fontFamily = Rubik,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        word.phonetic?.let { phonetic ->
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "[${phonetic.drop(1).dropLast(1)}]",
                fontFamily = Rubik,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        word.phonetics.forEach { phonetic ->
            if (phonetic.audio != "")
                IconButton(
                    onClick = {
                        val mediaPlayer = MediaPlayer()
                        mediaPlayer.setAudioAttributes(
                            AudioAttributes.Builder()
                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                .build()
                        )

                        try {
                            mediaPlayer.setDataSource(context, Uri.parse(phonetic.audio))
                            mediaPlayer.prepare()
                            mediaPlayer.start()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_audio),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    word.meanings.forEach { meaning ->
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Part of Speech:",
                fontFamily = Rubik,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = meaning.partOfSpeech.replaceFirstChar(Char::titlecase),
                fontFamily = Rubik,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Meanings:",
            fontFamily = Rubik,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(11.dp))

        meaning.definitions.forEachIndexed { index, definition ->
            if (index == meaning.definitions.lastIndex) {
                WordCard(
                    definition = definition
                )
                Spacer(modifier = Modifier.height(16.dp))
            } else {
                WordCard(
                    definition = definition
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

        }
    }
}

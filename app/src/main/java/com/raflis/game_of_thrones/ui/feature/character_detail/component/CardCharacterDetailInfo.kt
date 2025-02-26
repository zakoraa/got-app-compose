package com.raflis.game_of_thrones.ui.feature.character_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raflis.game_of_thrones.R
import com.raflis.game_of_thrones.data.model.GoTCharacter
import com.raflis.game_of_thrones.ui.core.component.NetworkImage

@Composable
fun CardCharacterDetailInfo(
    character: GoTCharacter?,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(WindowInsets.safeDrawing.asPaddingValues()),
            horizontalAlignment = Alignment.Start,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    NetworkImage(
                        urlImage = character?.house?.image ?: "",
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(5.dp))

                    Text(
                        character?.house?.name?.fullName ?: "",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(2f)
                ) {
                    Text(character?.name ?: "", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(5.dp))
                    Text(
                        stringResource(R.string.actor, character?.actorName ?: ""),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        stringResource(R.string.age, character?.age ?: ""),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        stringResource(R.string.episode_count, character?.episodeCount ?: ""),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        stringResource(R.string.culture, character?.culture ?: ""),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(
                        stringResource(R.string.description),
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
                    )
                    Text(
                        character?.description ?: "",
                        style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 15.sp)
                    )
                }
            }

        }
    }
}

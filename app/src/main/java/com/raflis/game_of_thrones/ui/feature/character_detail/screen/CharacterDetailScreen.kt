package com.raflis.game_of_thrones.ui.feature.character_detail.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.raflis.game_of_thrones.R
import com.raflis.game_of_thrones.data.repository.GoTCharacterRepository
import com.raflis.game_of_thrones.ui.core.component.NetworkImage
import com.raflis.game_of_thrones.ui.feature.character_detail.component.CardCharacterDetailInfo

@Composable
fun CharacterDetailScreen(
    navHostController: NavHostController,
    characterId: Int,
    modifier: Modifier = Modifier
) {
    val repository = remember { GoTCharacterRepository() }
    val character = repository.getGoTCharacters().find { it.id == characterId }
    Box(modifier = modifier.fillMaxSize()) {
        NetworkImage(
            urlImage = character?.image ?: "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column {
            IconButton(
                onClick = { navHostController.popBackStack() }, modifier = Modifier
                    .padding(WindowInsets.statusBars.asPaddingValues())
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.ic_arrow_back_desc),
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(40.dp)
                )
            }
            Box(
                modifier = modifier.fillMaxSize()
            ) {
                CardCharacterDetailInfo(
                    character = character,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }

        }
    }
}

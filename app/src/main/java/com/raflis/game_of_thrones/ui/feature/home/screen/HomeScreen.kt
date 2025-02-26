package com.raflis.game_of_thrones.ui.feature.home.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.raflis.game_of_thrones.R
import com.raflis.game_of_thrones.data.repository.GoTCharacterRepository
import com.raflis.game_of_thrones.ui.feature.home.component.CharacterCardList
import com.raflis.game_of_thrones.ui.feature.home.view_model.HomeViewModel
import com.raflis.game_of_thrones.ui.feature.home.view_model.ViewModelFactory

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = ViewModelFactory(GoTCharacterRepository())),
) {
    val groupedCharacters by viewModel.groupedCharacters.collectAsState()
    val query by viewModel.query
    Box(modifier = modifier.fillMaxSize()) {
        val listState = rememberLazyListState()

        CharacterCardList(
            groupedCharacters = groupedCharacters,
            listState = listState,
            query = query,
            onQueryChange = viewModel::search
        )

        FloatingActionButton(
            onClick = {},
            containerColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .windowInsetsPadding(WindowInsets.systemBars)
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = stringResource(R.string.about_page),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }

}
package com.raflis.game_of_thrones.ui.feature.home.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.raflis.game_of_thrones.data.repository.GoTCharacterRepository
import com.raflis.game_of_thrones.ui.feature.home.component.CharacterCard
import com.raflis.game_of_thrones.ui.feature.home.component.HomeHeader
import com.raflis.game_of_thrones.ui.feature.home.component.HomeSearchBar
import com.raflis.game_of_thrones.ui.feature.home.view_model.HomeViewModel
import com.raflis.game_of_thrones.ui.feature.home.view_model.ViewModelFactory

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = ViewModelFactory(GoTCharacterRepository()))
) {
    val groupedCharacters by viewModel.groupedCharacters.collectAsState()
    val query by viewModel.query
    Box(modifier = modifier) {
        val scope = rememberCoroutineScope()
        val listState = rememberLazyListState()
        val showButton: Boolean by remember {
            derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            item {
                HomeSearchBar(
                    query = query,
                    onQueryChange = viewModel::search,
                    modifier = Modifier.background(MaterialTheme.colorScheme.primary)
                )
            }
            stickyHeader {
                HomeHeader()
            }
            items(groupedCharacters.size, key = { it }) { index ->
                val item = groupedCharacters[index]

                CharacterCard(
                    name = item.name,
                    title = item.title,
                    image = item.image,
                    houseImage = item.house.image
                )
            }
        }
    }

}
package com.raflis.game_of_thrones.ui.feature.home.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.raflis.game_of_thrones.R
import com.raflis.game_of_thrones.data.model.GoTCharacter

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterCardList(
    groupedCharacters: List<GoTCharacter>,
    listState: LazyListState,
    query: String,
    onQueryChange: (String) -> Unit,
    onCharacterClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(bottom = 80.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        stickyHeader {
            HomeSearchBar(
                query = query,
                onQueryChange = onQueryChange,
                modifier = Modifier.background(MaterialTheme.colorScheme.primary)
            )
        }
        if (groupedCharacters.isEmpty()) {
            item {
                Text(
                    text = stringResource(R.string.no_data),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        } else {
            items(groupedCharacters.size, key = { it }) { index ->
                val item = groupedCharacters[index]
                CharacterCard(
                    name = item.name,
                    title = item.title,
                    image = item.image,
                    houseImage = item.house.image,
                    onClick = { onCharacterClick(item.id) }
                )
            }
        }
    }
}
package com.raflis.game_of_thrones.ui.feature.about.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.raflis.game_of_thrones.R

@Composable
fun AboutSection(innerPadding: PaddingValues, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(innerPadding)
            .fillMaxSize(),
    ) {
        Column {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(2.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.photo_profile),
                    contentDescription = stringResource(R.string.photo_profile_desc),
                    modifier = Modifier.clip(CircleShape)
                )
            }
            Text("Muhammad Rafli Silehu", style = MaterialTheme.typography.titleMedium)
            Text("raflisilehu20@gmail.com ")
            Text("Github: Zakoraa")
            Text("LinkedIn: Muhammad Rafli Silehu")
        }
    }
}
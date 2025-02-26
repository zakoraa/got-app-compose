package com.raflis.game_of_thrones.ui.feature.about.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState()),
        ) {

            Box(
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(2.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.photo_profile),
                    contentDescription = stringResource(R.string.photo_profile_desc),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .matchParentSize()
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text("Muhammad Rafli Silehu", style = MaterialTheme.typography.titleLarge)
            Text("raflisilehu20@gmail.com ")
            Text("Github: Zakoraa")
            Text("LinkedIn: Muhammad Rafli Silehu")
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}
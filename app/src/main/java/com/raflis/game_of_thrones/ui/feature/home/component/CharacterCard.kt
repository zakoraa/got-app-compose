package com.raflis.game_of_thrones.ui.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raflis.game_of_thrones.R
import com.raflis.game_of_thrones.ui.core.component.NetworkImage
import com.raflis.game_of_thrones.ui.theme.GameOfThronesTheme

@Composable
fun CharacterCard(
    name: String,
    title: String,
    image: String,
    houseImage: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(horizontal = 15.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 15.dp)
        ) {
            Column {
                Text(
                    name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(160.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    title,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(160.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = onClick) {
                    Text(stringResource(R.string.see_detail))
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(110.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(20.dp)
                    )
            ) {
                NetworkImage(
                    urlImage = image,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )
                NetworkImage(
                    urlImage = houseImage,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(30.dp)
                        .align(Alignment.TopEnd)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CharacterCardPreview() {
    GameOfThronesTheme {
        CharacterCard(
            "Flora Shafiqa Riyadi",
            title = "Istri Rafli",
            image = "https://upload.wikimedia.org/wikipedia/en/5/52/Ned_Stark-Sean_Bean.jpg",
            houseImage = "https://static.wikia.nocookie.net/gameofthrones/images/7/7e/House_Stark.svg/revision/latest/thumbnail/width/360/height/360?cb=20230905233833",
            onClick = {}
        )
    }
}

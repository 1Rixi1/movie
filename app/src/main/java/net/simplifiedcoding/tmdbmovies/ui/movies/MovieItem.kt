package net.simplifiedcoding.tmdbmovies.ui.movies

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import net.simplifiedcoding.tmdbmovies.R
import net.simplifiedcoding.tmdbmovies.data.models.Movie
import net.simplifiedcoding.tmdbmovies.ui.theme.AppTheme
import net.simplifiedcoding.tmdbmovies.ui.theme.spacing
import androidx.compose.runtime.*
import androidx.compose.ui.res.colorResource


import androidx.compose.ui.res.dimensionResource

@Composable
fun PhotoItem(movie: Movie, modifier: Modifier = Modifier) {
    val spacing = MaterialTheme.spacing

    var isAdditionalTextVisible by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(spacing.small)
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.movie_item_corner_radius)))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.photo_background_start),
                        colorResource(id = R.color.photo_background_end)
                    )
                )
            )
            .border(
                border = BorderStroke(
                    width = dimensionResource(id = R.dimen.movie_item_border_width),
                    color = colorResource(id = R.color.photo_border).copy(alpha = 0.2f)
                ),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.movie_item_corner_radius))
            )
            .shadow(
                elevation = dimensionResource(id = R.dimen.movie_item_elevation),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.movie_item_corner_radius))
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.medium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.thumbnailUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.description_photo),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.movie_item_image_size))
                    .clip(CircleShape)
                    .border(
                        width = dimensionResource(id = R.dimen.movie_item_border_width),
                        color = colorResource(id = R.color.photo_border_alpha),
                        shape = CircleShape
                    )
                    .shadow(
                        elevation = 12.dp,
                        shape = CircleShape
                    )
                    .background(colorResource(id = R.color.photo_circle_background))
            )

            Spacer(modifier = Modifier.height(spacing.medium))

            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.White
                ),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )


            if (isAdditionalTextVisible) {
                Text(
                    text = stringResource(id = R.string.additional_text),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Italic,
                        color = colorResource(id = R.color.additional_text_color)
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp)
                )
            }


            Button(
                onClick = {

                    isAdditionalTextVisible = !isAdditionalTextVisible
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.button_background),
                    contentColor = colorResource(id = R.color.button_text_color)
                ),
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .shadow(8.dp, RoundedCornerShape(50))
            ) {
                Text(
                    text = if (isAdditionalTextVisible) {
                        stringResource(id = R.string.hide_additional_text)
                    } else {
                        stringResource(id = R.string.show_additional_text)
                    },
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}





val jsonString = """
    {
        "albumId": 1,
        "id": 1,
        "title": "accusamus beatae ad facilis cum similique qui sunt",
        "url": "https://via.placeholder.com/600/92c952",
        "thumbnailUrl": "https://via.placeholder.com/150/92c952"
    }
""".trimIndent()

val movie = Json.decodeFromString<Movie>(jsonString)

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PhotoItemPreviewDark() {
    AppTheme {
        PhotoItem(movie)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PhotoItemPreviewLight() {
    AppTheme {
        PhotoItem(movie)
    }
}

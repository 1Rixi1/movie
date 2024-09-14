package net.simplifiedcoding.tmdbmovies.ui.movies
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.simplifiedcoding.tmdbmovies.data.models.Movie

@Composable
fun MovieList(movies: List<Movie>, onItemClick: (Movie) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(movies) { item ->
                PhotoItem(
                    movie = item,
                    modifier = Modifier
                        .clickable { onItemClick(item) }
                )
            }
        }
    }
}
package id.antasari.idantasarimovie_explorer_230104040080.ui.screen.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.antasari.idantasarimovie_explorer_230104040080.data.model.Movie
import id.antasari.idantasarimovie_explorer_230104040080.ui.components.SectionHeader

@Composable
fun MovieSection(
    title: String,
    movies: List<Movie>
) {
    SectionHeader(title = title)
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(movies) { movie ->
            MovieItemCard(
                movie = movie,
                modifier = Modifier
                    .width(150.dp)
            )
        }
    }
}
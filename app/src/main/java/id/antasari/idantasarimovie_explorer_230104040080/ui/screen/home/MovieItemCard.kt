package id.antasari.idantasarimovie_explorer_230104040080.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import id.antasari.idantasarimovie_explorer_230104040080.data.model.Movie
import id.antasari.idantasarimovie_explorer_230104040080.ui.components.AppCard
import id.antasari.idantasarimovie_explorer_230104040080.ui.components.RatingBadge
import id.antasari.idantasarimovie_explorer_230104040080.ui.theme.MovieCardOverlay

@Composable
fun MovieItemCard(
    movie: Movie,
    modifier: Modifier = Modifier
) {
    AppCard(
        modifier = modifier
    ) {
        Column {

            // Poster area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f / 3f)
                    .clip(RoundedCornerShape(16.dp)),   // biar sudut poster halus
                contentAlignment = Alignment.BottomStart
            ) {
                // Gambar poster
                Image(
                    painter = painterResource(id = movie.posterResId),
                    contentDescription = movie.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Overlay gelap tipis di bawah judul
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .background(MovieCardOverlay)
                        .padding(8.dp)
                ) {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Rating badge di pojok kanan atas
                RatingBadge(
                    rating = movie.rating,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Judul penuh di bawah poster
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            // Category + year
            Text(
                text = "${movie.category} • ${movie.year}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}

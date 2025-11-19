package id.antasari.idantasarimovie_explorer_230104040080.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.antasari.idantasarimovie_explorer_230104040080.ui.theme.RatingYellow

@Composable
fun RatingBadge(
    rating: Double,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = RatingYellow,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Rating",
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = String.format("%.1f", rating),
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}
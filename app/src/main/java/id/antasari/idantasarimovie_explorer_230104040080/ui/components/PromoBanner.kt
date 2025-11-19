package id.antasari.idantasarimovie_explorer_230104040080.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import id.antasari.idantasarimovie_explorer_230104040080.R

@Composable
fun PromoBanner(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(170.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.promo_home_banner),
            contentDescription = "Promo Banner",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp)),
            contentScale = ContentScale.Crop
        )
    }
}

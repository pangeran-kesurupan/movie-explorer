package id.antasari.idantasarimovie_explorer_230104040080.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.antasari.idantasarimovie_explorer_230104040080.data.dummy.DummyMovieData
import id.antasari.idantasarimovie_explorer_230104040080.ui.components.AppCard
import id.antasari.idantasarimovie_explorer_230104040080.ui.components.SectionHeader

// ---------- HOME TAB (SUDAH ADA, TAPI KITA PISAH UNTUK RAPI) ----------

@Composable
fun HomeTabContent() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))

            // Banner promo di atas
            id.antasari.idantasarimovie_explorer_230104040080.ui.components.PromoBanner()
            Spacer(modifier = Modifier.height(24.dp))

            MovieSection(
                title = "Popular Movies",
                movies = DummyMovieData.popularMovies
            )
            Spacer(modifier = Modifier.height(16.dp))

            MovieSection(
                title = "Trending TV Shows",
                movies = DummyMovieData.trendingTvShows
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

// ---------- MY BOOKING TAB ----------

data class BookingItem(
    val movieTitle: String,
    val cinemaName: String,
    val date: String,
    val time: String,
    val seats: String
)

private val dummyBookings = listOf(
    BookingItem(
        "Inception",
        "Cinepolis Banjarbaru",
        "20 Nov 2025",
        "19:30",
        "C5, C6"
    ),
    BookingItem(
        "Stranger Things Marathon",
        "Cinema XXI Banjarmasin",
        "22 Nov 2025",
        "21:00",
        "D7, D8, D9"
    )
)

@Composable
fun MyBookingTabContent() {
    if (dummyBookings.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Belum ada booking.",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Mulai pesan tiket untuk jadwal nontonmu!",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            item {
                SectionHeader(title = "Upcoming Booking")
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(dummyBookings) { booking ->
                AppCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column {
                        Text(
                            text = booking.movieTitle,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = booking.cinemaName,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "${booking.date} • ${booking.time}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                        )
                        Text(
                            text = "Seat: ${booking.seats}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(onClick = { /* TODO: show QR / detail */ }) {
                                Text("View Ticket")
                            }
                        }
                    }
                }
            }
        }
    }
}

// ---------- MOVIE TAB (ALL MOVIES LIST) ----------

@Composable
fun MovieTabContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        item {
            SectionHeader(title = "All Movies")
            Spacer(modifier = Modifier.height(8.dp))
        }

        items(DummyMovieData.popularMovies + DummyMovieData.trendingTvShows) { movie ->
            AppCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Column {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "${movie.category} • ${movie.year}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                    Text(
                        text = "Rating: ${movie.rating}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.9f)
                    )
                }
            }
        }
    }
}

// ---------- CINEMA TAB ----------

data class CinemaItem(
    val name: String,
    val location: String,
    val distanceKm: String
)

private val dummyCinemas = listOf(
    CinemaItem("Cinepolis Banjarbaru", "Q Mall Banjarbaru", "1.2 km"),
    CinemaItem("Cinema XXI Banjarmasin", "Duta Mall", "35 km"),
    CinemaItem("Movimax Banjarmasin", "Pal 6", "30 km")
)

@Composable
fun CinemaTabContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        item {
            SectionHeader(title = "Nearby Cinemas")
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(dummyCinemas) { cinema ->
            AppCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Column {
                    Text(
                        text = cinema.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = cinema.location,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )
                    Text(
                        text = "Distance: ${cinema.distanceKm}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(onClick = { /* TODO: show showtimes */ }) {
                            Text("Showtimes")
                        }
                    }
                }
            }
        }
    }
}

// ---------- F&B TAB ----------

data class FnbItem(
    val name: String,
    val description: String,
    val price: String
)

private val dummyFnb = listOf(
    FnbItem("Popcorn Caramel", "Medium bucket popcorn caramel", "Rp 35.000"),
    FnbItem("Popcorn Butter", "Large popcorn butter + drink", "Rp 45.000"),
    FnbItem("Cola Regular", "Minuman cola dingin", "Rp 18.000"),
    FnbItem("Combo Snack", "Popcorn + nugget + minuman", "Rp 55.000")
)

@Composable
fun FnbTabContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        item {
            SectionHeader(title = "Food & Beverages")
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(dummyFnb) { item ->
            AppCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Column {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item.price,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

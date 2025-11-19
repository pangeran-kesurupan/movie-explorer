package id.antasari.idantasarimovie_explorer_230104040080.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import id.antasari.idantasarimovie_explorer_230104040080.ui.components.BottomNavDestination
import id.antasari.idantasarimovie_explorer_230104040080.ui.components.MainBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateProfile: () -> Unit,
    onNavigateSettings: () -> Unit
) {
    // state tab bottom nav
    val (currentBottom, setCurrentBottom) = remember {
        mutableStateOf(BottomNavDestination.Home)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = when (currentBottom) {
                            BottomNavDestination.Home -> "Discover"
                            BottomNavDestination.MyBooking -> "My Booking"
                            BottomNavDestination.Movie -> "Movies"
                            BottomNavDestination.Cinema -> "Cinemas"
                            BottomNavDestination.FNB -> "Food & Beverages"
                        },
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                actions = {
                    IconButton(onClick = onNavigateProfile) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile"
                        )
                    }
                    IconButton(onClick = onNavigateSettings) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings"
                        )
                    }
                }
            )
        },
        bottomBar = {
            MainBottomBar(
                current = currentBottom,
                onDestinationSelected = setCurrentBottom
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            when (currentBottom) {
                BottomNavDestination.Home -> HomeTabContent()
                BottomNavDestination.MyBooking -> MyBookingTabContent()
                BottomNavDestination.Movie -> MovieTabContent()
                BottomNavDestination.Cinema -> CinemaTabContent()
                BottomNavDestination.FNB -> FnbTabContent()
            }
        }
    }
}

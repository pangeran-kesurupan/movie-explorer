package id.antasari.idantasarimovie_explorer_230104040080.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavDestination(
    val label: String,
    val icon: ImageVector
) {
    Home("Home", Icons.Filled.Home),
    MyBooking("My Booking", Icons.Filled.ReceiptLong),
    Movie("Movie", Icons.Filled.Movie),
    Cinema("Cinema", Icons.Filled.Storefront),
    FNB("F&B", Icons.Filled.Fastfood)
}

@Composable
fun MainBottomBar(
    current: BottomNavDestination,
    onDestinationSelected: (BottomNavDestination) -> Unit
) {
    NavigationBar {
        BottomNavDestination.entries.forEach { dest ->
            NavigationBarItem(
                selected = dest == current,
                onClick = { onDestinationSelected(dest) },
                icon = { Icon(imageVector = dest.icon, contentDescription = dest.label) },
                label = { Text(dest.label) }
            )
        }
    }
}

/**
 * Versi simpel kalau dipakai di 1 screen tanpa state di luar.
 * (Opsional, tapi berguna di HomeScreen)
 */
@Composable
fun RememberingBottomBar() {
    val (current, setCurrent) = remember { mutableStateOf(BottomNavDestination.Home) }
    MainBottomBar(current = current, onDestinationSelected = setCurrent)
}
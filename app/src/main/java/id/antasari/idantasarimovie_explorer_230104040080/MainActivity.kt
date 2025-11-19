package id.antasari.idantasarimovie_explorer_230104040080

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import id.antasari.idantasarimovie_explorer_230104040080.navigation.AppNavGraph
import id.antasari.idantasarimovie_explorer_230104040080.ui.theme.MovieExplorerTheme
import id.antasari.idantasarimovie_explorer_230104040080.util.ThemeState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var themeState by rememberSaveable(stateSaver = ThemeState.Saver) {
                mutableStateOf(ThemeState(isDarkTheme = false))
            }

            MovieExplorerTheme(darkTheme = themeState.isDarkTheme) {
                val navController = rememberNavController()

                AppNavGraph(
                    navController = navController,
                    isDarkTheme = themeState.isDarkTheme,
                    onThemeChanged = { isDark ->
                        themeState = themeState.copy(isDarkTheme = isDark)
                    }
                )
            }
        }
    }
}
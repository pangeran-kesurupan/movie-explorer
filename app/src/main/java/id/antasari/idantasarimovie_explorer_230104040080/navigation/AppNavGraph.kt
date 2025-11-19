package id.antasari.idantasarimovie_explorer_230104040080.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.antasari.idantasarimovie_explorer_230104040080.ui.screen.home.HomeScreen
import id.antasari.idantasarimovie_explorer_230104040080.ui.screen.login.LoginScreen
import id.antasari.idantasarimovie_explorer_230104040080.ui.screen.profile.ProfileScreen
import id.antasari.idantasarimovie_explorer_230104040080.ui.screen.settings.SettingsScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    isDarkTheme: Boolean,
    onThemeChanged: (Boolean) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateProfile = { navController.navigate(Screen.Profile.route) },
                onNavigateSettings = { navController.navigate(Screen.Settings.route) }
            )
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen(
                isDarkTheme = isDarkTheme,
                onThemeChanged = onThemeChanged,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
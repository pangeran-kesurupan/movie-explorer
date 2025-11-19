package id.antasari.idantasarimovie_explorer_230104040080.util


import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver

data class ThemeState(
    val isDarkTheme: Boolean = false
) {
    companion object {
        val Saver: Saver<ThemeState, Any> = listSaver(
            save = { listOf(it.isDarkTheme) },
            restore = { ThemeState(isDarkTheme = it[0] as Boolean) }
        )
    }
}
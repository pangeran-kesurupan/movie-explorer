package id.antasari.idantasarimovie_explorer_230104040080.data.model

import androidx.annotation.DrawableRes

data class Movie(
    val id: Int,
    val title: String,
    val rating: Double,
    val category: String,      // "Movie" atau "TV Show"
    val year: Int,
    val isTvShow: Boolean = false,
    @DrawableRes val posterResId: Int      // ⬅️ poster drawable
)
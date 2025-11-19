package id.antasari.idantasarimovie_explorer_230104040080.data.dummy

import id.antasari.idantasarimovie_explorer_230104040080.R
import id.antasari.idantasarimovie_explorer_230104040080.data.model.Movie

object DummyMovieData {

    val popularMovies = listOf(
        Movie(
            id = 1,
            title = "Inception",
            rating = 8.8,
            category = "Movie",
            year = 2010,
            posterResId = R.drawable.inception
        ),
        Movie(
            id = 2,
            title = "Interstellar",
            rating = 8.6,
            category = "Movie",
            year = 2014,
            posterResId = R.drawable.interstellar
        ),
        Movie(
            id = 3,
            title = "The Dark Knight",
            rating = 9.0,
            category = "Movie",
            year = 2008,
            posterResId = R.drawable.darkknight
        ),
        Movie(
            id = 4,
            title = "Dune: Part One",
            rating = 8.1,
            category = "Movie",
            year = 2021,
            posterResId = R.drawable.dune
        ),
        Movie(
            id = 5,
            title = "La La Land",
            rating = 8.0,
            category = "Movie",
            year = 2016,
            posterResId = R.drawable.lalaland
        )
    )

    val trendingTvShows = listOf(
        Movie(
            id = 6,
            title = "Breaking Bad",
            rating = 9.5,
            category = "TV Show",
            year = 2008,
            isTvShow = true,
            posterResId = R.drawable.breakingbad
        ),
        Movie(
            id = 7,
            title = "Stranger Things",
            rating = 8.7,
            category = "TV Show",
            year = 2016,
            isTvShow = true,
            posterResId = R.drawable.strangerthins
        ),
        Movie(
            id = 8,
            title = "The Witcher",
            rating = 8.2,
            category = "TV Show",
            year = 2019,
            isTvShow = true,
            posterResId = R.drawable.thewitcher
        ),
        Movie(
            id = 9,
            title = "The Last of Us",
            rating = 8.8,
            category = "TV Show",
            year = 2023,
            isTvShow = true,
            posterResId = R.drawable.thelastofus
        ),
        Movie(
            id = 10,
            title = "Loki",
            rating = 8.3,
            category = "TV Show",
            year = 2021,
            isTvShow = true,
            posterResId = R.drawable.loki
        )
    )
}

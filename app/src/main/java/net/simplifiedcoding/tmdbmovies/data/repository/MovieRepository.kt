package net.simplifiedcoding.tmdbmovies.data.repository

import net.simplifiedcoding.tmdbmovies.data.models.Movie
import net.simplifiedcoding.tmdbmovies.data.network.Resource


interface MovieRepository {
    suspend fun getPopularMovies(): Resource<List<Movie>>
}
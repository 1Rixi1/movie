package net.simplifiedcoding.tmdbmovies.data.repository

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import net.simplifiedcoding.tmdbmovies.data.models.Movie
import net.simplifiedcoding.tmdbmovies.data.network.BASE_URL
import net.simplifiedcoding.tmdbmovies.data.network.Resource
import javax.inject.Inject

private const val POPULAR_MOVIES = "${BASE_URL}/photos"

class MovieRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : MovieRepository {

    override suspend fun getPopularMovies(): Resource<List<Movie>> {
        return try {

            val movies: List<Movie> = httpClient.get(POPULAR_MOVIES).body()

            Resource.Success(movies)

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }
}

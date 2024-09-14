package net.simplifiedcoding.tmdbmovies.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import net.simplifiedcoding.tmdbmovies.data.network.TmdbHttpClient
import net.simplifiedcoding.tmdbmovies.data.repository.MovieRepository
import net.simplifiedcoding.tmdbmovies.data.repository.MovieRepositoryImpl

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun getHttpClient(httpClient: TmdbHttpClient): HttpClient = httpClient.getHttpClient()

    @Provides
    fun getMoviesRepository(impl: MovieRepositoryImpl): MovieRepository = impl
}
package net.simplifiedcoding.tmdbmovies.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.simplifiedcoding.tmdbmovies.data.models.Movie
import net.simplifiedcoding.tmdbmovies.data.network.Resource
import net.simplifiedcoding.tmdbmovies.data.repository.MovieRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movie = MutableStateFlow<Resource<List<Movie>>?>(null)
    val movies: StateFlow<Resource<List<Movie>>?> = _movie

    init {
        viewModelScope.launch {
            _movie.value = Resource.Loading
            _movie.value = repository.getPopularMovies()
        }
    }
}
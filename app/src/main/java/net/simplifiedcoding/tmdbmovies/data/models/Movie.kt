package net.simplifiedcoding.tmdbmovies.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)
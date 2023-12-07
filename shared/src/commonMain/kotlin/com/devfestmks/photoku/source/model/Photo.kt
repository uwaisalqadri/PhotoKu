package com.devfestmks.photoku.source.model

import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    val imageUrl: String,
    val name: String
)
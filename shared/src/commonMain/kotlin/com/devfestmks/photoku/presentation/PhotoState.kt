package com.devfestmks.photoku.presentation

import com.devfestmks.photoku.source.model.Photo

data class PhotoState(
    val photos: List<Photo> = listOf(),
    val isEmpty: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)

package com.devfestmks.photoku.presentation

sealed class PhotoEvent {
    data object GetPhotos: PhotoEvent()
    data class Error(val message: String): PhotoEvent()
}
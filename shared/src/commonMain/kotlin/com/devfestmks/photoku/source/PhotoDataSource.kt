package com.devfestmks.photoku.source

import com.devfestmks.photoku.source.model.Photo

interface PhotoDataSource {
    suspend fun getPhotos(query: String): List<Photo>
}
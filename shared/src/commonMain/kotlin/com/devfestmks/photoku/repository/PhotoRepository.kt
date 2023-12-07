package com.devfestmks.photoku.repository

import com.devfestmks.photoku.source.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
    suspend fun getPhotos(query: String): Flow<List<Photo>>
}
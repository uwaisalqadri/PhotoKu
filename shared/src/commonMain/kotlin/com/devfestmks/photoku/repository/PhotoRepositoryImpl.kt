package com.devfestmks.photoku.repository

import com.devfestmks.photoku.source.PhotoDataSource
import com.devfestmks.photoku.source.model.Photo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PhotoRepositoryImpl(private val dataSource: PhotoDataSource): PhotoRepository {
    override suspend fun getPhotos(query: String): Flow<List<Photo>> {
        return flow {
            emit(dataSource.getPhotos(query))
        }
    }
}
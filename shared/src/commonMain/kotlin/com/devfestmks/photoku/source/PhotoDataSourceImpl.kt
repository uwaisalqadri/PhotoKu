package com.devfestmks.photoku.source

import com.devfestmks.photoku.source.model.Photo
import com.devfestmks.photoku.utils.ResourceReader
import kotlinx.serialization.json.Json

class PhotoDataSourceImpl(private val json: Json, private val reader: ResourceReader): PhotoDataSource {
    override suspend fun getPhotos(query: String): List<Photo> {
        val jsonFile = reader.readResource("photos.json")
        return json.decodeFromString<List<Photo>>(jsonFile)
    }
}
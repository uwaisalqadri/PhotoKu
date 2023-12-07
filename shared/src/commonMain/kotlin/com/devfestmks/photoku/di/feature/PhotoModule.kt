package com.devfestmks.photoku.di.feature

import com.devfestmks.photoku.repository.PhotoRepository
import com.devfestmks.photoku.repository.PhotoRepositoryImpl
import com.devfestmks.photoku.source.PhotoDataSource
import com.devfestmks.photoku.source.PhotoDataSourceImpl
import org.koin.dsl.module

val photoModule = module {
    single<PhotoRepository> { PhotoRepositoryImpl(get()) }
    single<PhotoDataSource> { PhotoDataSourceImpl(get(), get()) }
}
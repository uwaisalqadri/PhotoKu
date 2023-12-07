package com.devfestmks.photoku.android.di

import com.devfestmks.photoku.presentation.PhotoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val featureModule = module {
    viewModelOf(::PhotoViewModel)
}
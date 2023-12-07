package com.devfestmks.photoku.presentation

import com.devfestmks.photoku.repository.PhotoRepository
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmm.viewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class PhotoViewModel: KMMViewModel(), KoinComponent {

    private val repository: PhotoRepository by inject()

    private val _state: MutableStateFlow<PhotoState> = MutableStateFlow(PhotoState())

    @NativeCoroutinesState
    val state: StateFlow<PhotoState> = _state
        .asStateFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), PhotoState())

    fun onTriggerEvent(event: PhotoEvent) {
        when (event) {
            is PhotoEvent.GetPhotos -> {
                getPhotos()
            }
            is PhotoEvent.Error -> {
                _state.value = _state.value.copy(errorMessage = event.message)
            }
        }
    }

    private fun getPhotos() = viewModelScope.coroutineScope.launch {
        _state.value = _state.value.copy(isLoading = true)

        repository.getPhotos("").catch { cause: Throwable ->
            _state.value = _state.value.copy(errorMessage = cause.message.orEmpty())
        }.collect {
            if (it.isEmpty()) _state.value = PhotoState(isEmpty = true)
            else _state.value = PhotoState(photos = it)
        }
    }
}
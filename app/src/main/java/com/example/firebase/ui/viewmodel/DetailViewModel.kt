package com.example.firebase.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebase.model.Mahasiswa
import com.example.firebase.repository.MhsRepository
import kotlinx.coroutines.launch

sealed class DetailUiState{
    data class Success(
        val mahasiswa: Mahasiswa
    ): DetailUiState()
    object Error: DetailUiState()
    object Loading: HomeUiState()
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val mhs: MhsRepository
): ViewModel(){
    var mhsUiState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    private val _nim: String = checkNotNull(savedStateHandle[DestinasiDetail.NIM])

    init {
        getMahasiswabynim()
    }

    fun getMahasiswabynim(){
        viewModelScope.launch {
            mhsUiState = DetailUiState.Loading
            mhsUiState = try {
                DetailUiState.Success(mhs.getMahasiswabynim(_nim))
            } catch (e: Exception){
                DetailUiState.Error
            }
        }
    }
}

fun Mahasiswa.toDetailUiEvent(): MahasiswaEvent{
    return MahasiswaEvent(
        nim = nim,
        nama = nama,
        alamat = alamat,
        jeniskelamin = jeniskelamin,
        kelas = kelas,
        angkatan = angkatan
    )
}
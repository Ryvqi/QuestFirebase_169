package com.example.firebase.ui.viewmodel

sealed class FormState{
    object Idle: FormState()
    object Loading: FormState()
    data class Success(val message: String): FormState()
    data class Error(val message: String): FormState()
}

data class InsertUiState(
    val insertUiEvent: MahasiswaEvent = MahasiswaEvent(),
    val isEntryValid: FormErrorState = FormErrorState()
)

data class FormErrorState(
    val nim: String? = null,
    val nama: String? = null,
    val jeniskelamin: String? = null,
    val alamat: String? = null,
    val kelas: String? = null,
    val angkatan: String? = null,
){
    fun isValid(): Boolean{
        return nim == null && nama == null && jeniskelamin == null &&
                alamat == null && kelas == null && angkatan == null
    }
}

//data class variable yang menyimpan data input form
data class MahasiswaEvent(
    val nim: String = "",
    val nama: String = "",
    val jeniskelamin: String = "",
    val alamat: String = "",
    val kelas: String = "",
    val angkatan: String = "",
)
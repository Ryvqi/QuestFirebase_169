package com.example.firebase.repository

import com.example.firebase.model.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface MhsRepository {
    suspend fun getAllMahasiswa(): Flow<List<Mahasiswa>>
    suspend fun getMahasiswabynim(nim: String): Mahasiswa
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(nim: String)
}
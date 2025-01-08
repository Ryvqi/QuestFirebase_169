package com.example.firebase.dependensiinjection

import com.example.firebase.repository.MhsRepository
import com.example.firebase.repository.NetworkMhsRepository
import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer{
    val mhsRepository: MhsRepository
}

class MhsContainer : AppContainer{
    private val firebase: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val mhsRepository: MhsRepository by lazy {
        NetworkMhsRepository(firebase)
    }
}
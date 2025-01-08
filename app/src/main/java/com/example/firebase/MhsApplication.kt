package com.example.firebase

import android.app.Application
import com.example.firebase.dependensiinjection.AppContainer
import com.example.firebase.dependensiinjection.MhsContainer

class MhsApplication : Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MhsContainer()
    }
}
package com.example.example_sqlite

import android.app.Application
import com.example.example_sqlite.di.androidModule
import org.koin.android.ext.android.startKoin
import org.koin.standalone.StandAloneContext

class SqliteApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(androidModule))
    }
    override fun onTerminate() {
        super.onTerminate()
        StandAloneContext.stopKoin()
    }
}
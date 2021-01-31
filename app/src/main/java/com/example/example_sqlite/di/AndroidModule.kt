package com.example.example_sqlite.di

import com.example.example_sqlite.service.UserService
import com.example.example_sqlite.ui.model.UserViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val androidModule = module {
    single {
        this
    }

    single {
        UserService(get())
    }

    viewModel {
        UserViewModel(get())
    }
}
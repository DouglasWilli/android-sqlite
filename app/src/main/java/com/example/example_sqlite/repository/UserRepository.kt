package com.example.example_sqlite.repository

import com.example.example_sqlite.model.User

interface UserRepository {

    fun save(
        user: User,
        success: (User?) -> Unit,
        error: (Exception?) -> Unit)
}
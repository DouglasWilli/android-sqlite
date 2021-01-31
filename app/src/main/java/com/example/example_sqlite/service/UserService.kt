package com.example.example_sqlite.service

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import androidx.lifecycle.LiveData
import com.example.example_sqlite.model.User
import com.example.example_sqlite.repository.UserRepository
import com.example.example_sqlite.sqlite.COLUMN_EMAIL
import com.example.example_sqlite.sqlite.COLUMN_ID
import com.example.example_sqlite.sqlite.COLUMN_NAME
import com.example.example_sqlite.sqlite.TABLE_USER
import com.example.example_sqlite.sqlite.helper.UserSqlHelper

class UserService(context: Context) : UserRepository {

    private val helper: UserSqlHelper = UserSqlHelper(context)

    override fun save(
        user: User,
        success: (User?) -> Unit,
        error: (Exception?) -> Unit) {
        val database = helper.writableDatabase
        val contentValue = ContentValues().apply {
            put(COLUMN_NAME, user.name)
            put(COLUMN_EMAIL, user.email)
        }
        val id = database.insert(TABLE_USER, null, contentValue)
        if(id != -1L) {
            user.id = id
        }
        database.close()
    }
}
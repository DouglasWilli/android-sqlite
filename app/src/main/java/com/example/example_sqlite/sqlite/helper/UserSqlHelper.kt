package com.example.example_sqlite.sqlite.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.example_sqlite.sqlite.*

class UserSqlHelper (context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE $TABLE_USER (" +
                    "$COLUMN_ID  INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COLUMN_NAME  TEXT, " +
                    "$COLUMN_EMAIL TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}
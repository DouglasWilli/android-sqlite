package com.example.example_sqlite.model

import java.io.Serializable

data class User(
    var id: Long = 0,
    var name: String? =  "",
    var email: String? =  "",
): Serializable {
    companion object{
        fun buildUser(user: User?): User {
            return User(
                name = user?.name,
                email = user?.email,
            )
        }
    }
}
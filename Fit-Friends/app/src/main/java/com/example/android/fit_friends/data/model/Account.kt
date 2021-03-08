package com.example.android.fit_friends.data.model

// we make a data class for each table in database
data class Account(
    val id: Long, val username: String, val password: String, val registerDate: String?
) {

    // it extends parent constructor
    constructor(username: String, password: String, registerDate: String?) : this(
        0,
        username,
        password,
        registerDate
    )


}
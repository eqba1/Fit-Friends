package com.example.android.fit_friends.data.model


// a data model of a person which has an account in system
open class Person(open val id: Long, open val firstName: String?, open val lastName: String?,
                  open val birthDate: String?, open val phoneNumber: String?, open val email: String?,
                  open val address: String?, open val nationalCardNumber: String?, open val account:Account)
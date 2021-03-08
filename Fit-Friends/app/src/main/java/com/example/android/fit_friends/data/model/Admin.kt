package com.example.android.fit_friends.data.model

// a data model for admin which extends person
// when we extend a class parent class and it's properties should declare open,
// and in child class be overriden
data class Admin(override val id: Long, override val firstName: String?, override val lastName: String?,
                 override val birthDate: String?, override val phoneNumber: String?, override val email: String?,
                 override val address: String?, override val nationalCardNumber: String?, override val account: Account) :
    Person(id, firstName, lastName, birthDate, phoneNumber, email, address, nationalCardNumber, account) {

    // build constructor, only account and id can't be null
    constructor(account: Account) : this(0, null, null, null, null, null, null, null, account)
}
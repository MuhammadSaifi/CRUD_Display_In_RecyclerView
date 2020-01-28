package com.example.dbdemo.model

class Contact {
    // HERE WE MODEL OUR CONTACTS.

    var id: Int = 0
    var name: String? = null
    var phoneNumber: String? = null

    // HERE I REMOVE ID FROM CONSTRUCTOR BECAUSE ID HANDLED BY OUR DATABASE.

    constructor(name: String, phoneNumber: String) {
        this.name = name
        this.phoneNumber = phoneNumber
    }

    // OVERLOADD OUR CONSTRUCTOR IF SOME GIVE ID THEN THIS WORK.

    constructor(id: Int, name: String, phoneNumber: String) {
        this.id = id
        this.name = name
        this.phoneNumber = phoneNumber
    }
    // IF NOTHING GIVE ANY DATA THEN BELOW WORK

    constructor() {}
}

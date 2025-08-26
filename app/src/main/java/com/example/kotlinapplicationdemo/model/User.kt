package com.example.kotlinapplicationdemo.model

open abstract class User {
    abstract var password : String
    abstract var email : String
    abstract fun login()
    abstract fun mainmenu()
}

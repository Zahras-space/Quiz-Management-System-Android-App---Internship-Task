package com.example.kotlinapplicationdemo.model


class Authentication {
    private fun verifyCredentials(
        email: String,
        password: String,
        credentialsArray: Array<Pair<String, String>>
    ): Boolean {
        for (credential in credentialsArray) {
            if (credential.first == email && credential.second == password) return true
        }
        return false
    }

    fun teacherVerify(email: String, password: String): Boolean {
        val teacherCredentials = arrayOf(
            "teacher@example.com" to "123",
            "ali@comsats.edu" to "ali123"
        )
        return verifyCredentials(email, password, teacherCredentials)
    }

    fun studentVerify(email: String, password: String): Boolean {
        val studentCredentials = arrayOf(
            "student@example.com" to "password",
            "john.doe@learn.org" to "learnpass",
            "jane.student@academy.net" to "kotlinfun"
        )
        return verifyCredentials(email, password, studentCredentials)
    }
}

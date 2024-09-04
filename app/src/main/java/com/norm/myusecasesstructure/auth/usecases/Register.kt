package com.norm.myusecasesstructure.auth.usecases

import com.norm.myusecasesstructure.auth.repository.AuthRepository

class Register(private val repo: AuthRepository) {
    suspend operator fun invoke(
        email: String, username: String, password: String,
    ) {
        if (!email.contains("@")) {
            return
        }
        if (password.length < 8) {
            return
        }
        if (username.length < 3) {
            return
        }

        return repo.register(email, username, password)
    }
}
package com.norm.myusecasesstructure.auth.usecases

import com.norm.myusecasesstructure.auth.repository.AuthRepository

class AuthenticationUseCase(
    private val repo: AuthRepository,
) {
    suspend fun register(
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

        repo.register(email, username, password)
    }

    suspend fun login(
        username: String, password: String,
    ) {
        if (password.length < 8) {
            return
        }
        if (username.length < 3) {
            return
        }

        repo.login(username, password)
    }

    suspend fun authentication(): Boolean {
        val accessToken = repo.getAssetsToken() ?: return false

        if (accessToken.isEmpty()) {
            return false
        }

        return repo.authenticate(accessToken)
    }
}
package com.norm.myusecasesstructure.auth.repository

interface AuthRepository {
    suspend fun register(
        email: String, username: String, password: String,
    )

    suspend fun login(
        username: String,
        password: String,
    )

    suspend fun getAssetsToken(): String?

    suspend fun authenticate(
        accessToken: String
    ): Boolean
}
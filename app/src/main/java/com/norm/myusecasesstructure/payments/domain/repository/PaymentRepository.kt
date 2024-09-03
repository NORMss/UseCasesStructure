package com.norm.myusecasesstructure.payments.domain.repository

interface PaymentRepository {
    suspend fun startTransaction(
        senderId: String,
        receiverId: String,
    ): String

    suspend fun sendPayment(
        amount: Double,
        senderId: String,
        receiverId: String,
        transactionId: String,
    )

    suspend fun getTransactionResult(
        transactionId: String,
    ): Boolean
}
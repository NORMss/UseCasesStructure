package com.norm.myusecasesstructure.payments.domain.usecases

import com.norm.myusecasesstructure.payments.domain.repository.PaymentRepository

class SendPayment(
    private val repo: PaymentRepository,
) {
    suspend operator fun invoke(
        amount: Double,
        senderId: String,
        receiverId: String,
    ): Boolean {
        val transactionId = repo.startTransaction(senderId, receiverId)

        repo.sendPayment(
            amount = amount,
            senderId = senderId,
            receiverId = receiverId,
            transactionId = transactionId,
        )

        return repo.getTransactionResult(transactionId)
    }
}
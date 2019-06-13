package com.kiwiandroiddev.epoxysharedelementtransition.model

import java.io.Serializable

data class CreditCard(
    val id: String,
    val cardNumber: String,
    val cardType: CardType,
    val fullName: String,
    val expiryDate: String
) : Serializable

enum class CardType {
    VISA,
    MASTERCARD,
    AMEX
}
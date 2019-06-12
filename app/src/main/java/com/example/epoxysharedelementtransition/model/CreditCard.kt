package com.example.epoxysharedelementtransition.model

import java.io.Serializable

data class CreditCard(
    val id: String,
    val cardNumber: String,
    val fullName: String,
    val expiryDate: String
) : Serializable
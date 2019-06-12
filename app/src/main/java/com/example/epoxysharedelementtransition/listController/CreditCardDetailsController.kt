package com.example.epoxysharedelementtransition.listController

import com.airbnb.epoxy.TypedEpoxyController
import com.example.epoxysharedelementtransition.listModel.creditCard
import com.example.epoxysharedelementtransition.model.CreditCard

class CreditCardDetailsController() : TypedEpoxyController<CreditCard>() {

    override fun buildModels(card: CreditCard) {
        creditCard {
            id(card.id)
            cardNumber(card.cardNumber)
            cardName(card.fullName)
            cardExpiryDate(card.expiryDate)
        }
    }

}
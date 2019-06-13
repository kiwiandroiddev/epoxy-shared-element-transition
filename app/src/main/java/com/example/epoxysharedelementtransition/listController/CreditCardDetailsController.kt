package com.example.epoxysharedelementtransition.listController

import com.airbnb.epoxy.TypedEpoxyController
import com.example.epoxysharedelementtransition.listModel.creditCard
import com.example.epoxysharedelementtransition.listModel.deleteButton
import com.example.epoxysharedelementtransition.model.CreditCard

class CreditCardDetailsController : TypedEpoxyController<CreditCard>() {

    override fun buildModels(card: CreditCard) {
        creditCard {
            id(card.id)
            cardId(card.id)
            cardNumber(card.cardNumber)
            cardType(card.cardType)
            cardName(card.fullName)
            cardExpiryDate(card.expiryDate)
        }

        deleteButton {}
    }

}
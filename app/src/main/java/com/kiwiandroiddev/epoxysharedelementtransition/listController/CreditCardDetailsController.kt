package com.kiwiandroiddev.epoxysharedelementtransition.listController

import com.airbnb.epoxy.TypedEpoxyController
import com.kiwiandroiddev.epoxysharedelementtransition.listModel.creditCard
import com.kiwiandroiddev.epoxysharedelementtransition.listModel.deleteButton
import com.kiwiandroiddev.epoxysharedelementtransition.model.CreditCard

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
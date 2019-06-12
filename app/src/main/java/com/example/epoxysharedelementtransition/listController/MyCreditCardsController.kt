package com.example.epoxysharedelementtransition.listController

import com.airbnb.epoxy.TypedEpoxyController
import com.example.epoxysharedelementtransition.listModel.creditCard
import com.example.epoxysharedelementtransition.model.CreditCard

class MyCreditCardsController : TypedEpoxyController<List<CreditCard>>() {

    override fun buildModels(cards: List<CreditCard>) {
        cards.forEach { card ->
            creditCard {
                id(card.id)
                cardNumber(card.cardNumber)
                cardName(card.fullName)
                cardExpiryDate(card.expiryDate)
                onClickListener {
                    // TODO
                }
            }
        }
    }

}
package com.kiwiandroiddev.epoxysharedelementtransition.listController

import android.view.View
import com.airbnb.epoxy.TypedEpoxyController
import com.kiwiandroiddev.epoxysharedelementtransition.listModel.creditCard
import com.kiwiandroiddev.epoxysharedelementtransition.model.CreditCard

class MyCreditCardsController(private val onClickListener: (cardId: String, cardView: View) -> Unit) : TypedEpoxyController<List<CreditCard>>() {

    override fun buildModels(cards: List<CreditCard>) {
        cards.forEach { card ->
            creditCard {
                id(card.id)
                cardId(card.id)
                cardNumber(card.cardNumber)
                cardType(card.cardType)
                cardName(card.fullName)
                cardExpiryDate(card.expiryDate)
                onClickListener { cardView -> onClickListener(card.id, cardView) }
            }
        }
    }

}
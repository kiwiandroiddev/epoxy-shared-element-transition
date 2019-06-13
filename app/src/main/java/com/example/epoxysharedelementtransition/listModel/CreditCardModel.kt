package com.example.epoxysharedelementtransition.listModel

import android.view.View
import android.widget.TextView
import androidx.core.view.ViewCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxysharedelementtransition.R

@EpoxyModelClass(layout = R.layout.list_item_credit_card)
abstract class CreditCardModel : EpoxyModelWithHolder<CreditCardModel.Holder>() {

    @EpoxyAttribute
    lateinit var cardId: String

    @EpoxyAttribute
    lateinit var cardNumber: String

    @EpoxyAttribute
    lateinit var cardName: String

    @EpoxyAttribute
    lateinit var cardExpiryDate: String

    @EpoxyAttribute
    var onClickListener: (cardView: View) -> Unit = {}

    override fun bind(holder: Holder) {
        holder.cardNumber.text = cardNumber
        holder.cardName.text = cardName
        holder.cardExpiryDate.text = "Expires: $cardExpiryDate"
        holder.cardContainer.setOnClickListener { onClickListener(holder.cardContainer) }

//        ViewCompat.setTransitionName(holder.cardContainer, "cardContainer")
        ViewCompat.setTransitionName(holder.cardContainer, "cardContainer_" + cardId)
    }

    class Holder : EpoxyHolder() {
        internal lateinit var cardNumber: TextView
        internal lateinit var cardName: TextView
        internal lateinit var cardExpiryDate: TextView
        internal lateinit var cardContainer: View

        override fun bindView(itemView: View) {
            cardNumber = itemView.findViewById(R.id.card_number)
            cardExpiryDate = itemView.findViewById(R.id.card_expiry_date)
            cardName = itemView.findViewById(R.id.card_name)
            cardContainer = itemView.findViewById(R.id.container)
        }
    }

}
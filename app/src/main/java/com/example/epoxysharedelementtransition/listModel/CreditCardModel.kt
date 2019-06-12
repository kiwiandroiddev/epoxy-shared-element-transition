package com.example.epoxysharedelementtransition.listModel

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxysharedelementtransition.R

@EpoxyModelClass(layout = R.layout.list_item_credit_card)
abstract class CreditCardModel : EpoxyModelWithHolder<CreditCardModel.Holder>() {

    @EpoxyAttribute
    lateinit var cardNumber: String

    @EpoxyAttribute
    lateinit var cardName: String

    @EpoxyAttribute
    lateinit var cardExpiryDate: String

    @EpoxyAttribute
    var onClickListener: () -> Unit = {}

    override fun bind(holder: Holder) {
        holder.cardNumber.text = cardNumber
        holder.cardName.text = cardName
        holder.cardExpiryDate.text = "Expires: $cardExpiryDate"
        holder.cardContainer.setOnClickListener { onClickListener() }

//        val transitionName = "card_" + id().toString()
//        Timber.d("setting card details view transition name to: $transitionName")
//        ViewCompat.setTransitionName(holder.cta, transitionName)
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
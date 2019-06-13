package com.example.epoxysharedelementtransition.listModel

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxysharedelementtransition.R
import com.example.epoxysharedelementtransition.model.CardType
import com.example.epoxysharedelementtransition.model.CardType.*

@EpoxyModelClass(layout = R.layout.list_item_credit_card)
abstract class CreditCardModel : EpoxyModelWithHolder<CreditCardModel.Holder>() {

    @EpoxyAttribute
    lateinit var cardId: String

    @EpoxyAttribute
    lateinit var cardNumber: String

    @EpoxyAttribute
    lateinit var cardType: CardType

    @EpoxyAttribute
    lateinit var cardName: String

    @EpoxyAttribute
    lateinit var cardExpiryDate: String

    @EpoxyAttribute
    var onClickListener: (cardView: View) -> Unit = {}

    override fun bind(holder: Holder) {
        holder.cardNumber.text = cardNumber
        holder.cardIcon.setImageResource(cardType.toDrawableResId() ?: 0)
        holder.cardName.text = cardName
        holder.cardExpiryDate.text = "Expires: $cardExpiryDate"
        holder.cardContainer.setOnClickListener { onClickListener(holder.cardContainer) }

        ViewCompat.setTransitionName(holder.cardContainer, "cardContainer_" + cardId)
    }

    class Holder : EpoxyHolder() {
        internal lateinit var cardNumber: TextView
        internal lateinit var cardIcon: ImageView
        internal lateinit var cardName: TextView
        internal lateinit var cardExpiryDate: TextView
        internal lateinit var cardContainer: View

        override fun bindView(itemView: View) {
            cardNumber = itemView.findViewById(R.id.card_number)
            cardIcon = itemView.findViewById(R.id.card_icon)
            cardExpiryDate = itemView.findViewById(R.id.card_expiry_date)
            cardName = itemView.findViewById(R.id.card_name)
            cardContainer = itemView.findViewById(R.id.container)
        }
    }

    private fun CardType.toDrawableResId(): Int {
        return when(this) {
            VISA -> R.drawable.ic_visa_logo
            MASTERCARD -> R.drawable.ic_mastercard_logo
            AMEX -> R.drawable.ic_american_express_logo
        }
    }

}

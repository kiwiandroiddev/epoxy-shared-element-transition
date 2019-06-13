package com.kiwiandroiddev.epoxysharedelementtransition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.*
import com.airbnb.epoxy.EpoxyRecyclerView
import com.kiwiandroiddev.epoxysharedelementtransition.listController.MyCreditCardsController
import com.kiwiandroiddev.epoxysharedelementtransition.model.CardType
import com.kiwiandroiddev.epoxysharedelementtransition.model.CreditCard

class CardListFragment : Fragment() {

    companion object {
        fun newInstance() = CardListFragment()

        private val sampleCards = listOf(
            CreditCard(id = "001", cardNumber = "**** **** **** 0231", cardType = CardType.VISA, fullName = "John Doe", expiryDate = "06/22"),
            CreditCard(id = "002", cardNumber = "**** **** **** 8093", cardType = CardType.MASTERCARD, fullName = "Mr. John M. Doe", expiryDate = "03/20"),
            CreditCard(id = "003", cardNumber = "**** **** **** 3001", cardType = CardType.AMEX, fullName = "JOHN DOE", expiryDate = "12/21"),
            CreditCard(id = "004", cardNumber = "**** **** **** 4151", cardType = CardType.VISA, fullName = "MR SMITH", expiryDate = "02/22"),
            CreditCard(id = "005", cardNumber = "**** **** **** 6431", cardType = CardType.MASTERCARD, fullName = "DR JONES", expiryDate = "09/20"),
            CreditCard(id = "006", cardNumber = "**** **** **** 9289", cardType = CardType.AMEX, fullName = "M J WATSON", expiryDate = "11/22")
        )
    }

    private val listController = MyCreditCardsController(this::onCardClicked)

    lateinit var epoxyRecyclerView: EpoxyRecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_card_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postponeEnterTransition()
        epoxyRecyclerView = view.findViewById(R.id.epoxy_recycler_view)
        epoxyRecyclerView.layoutManager = LinearLayoutManager(context)
        epoxyRecyclerView.setController(listController)

        listController.setData(sampleCards)

        // start return transition only after RecyclerView animations have finished
        epoxyRecyclerView.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }
    }

    private fun onCardClicked(creditCardId: String, sharedElement: View) {
        val detailsFragment = CardDetailsFragment.newInstance(getCardById(creditCardId))

        val baseDurationMs = 250L

        exitTransition = Fade()
            .excludeTarget(sharedElement, true)
            .setDuration(baseDurationMs)

        reenterTransition = Fade()
            .excludeTarget(sharedElement, true)
            .setDuration(baseDurationMs)

        detailsFragment.enterTransition = Fade()
            .setDuration(baseDurationMs)
            .setStartDelay(baseDurationMs * 2)
            .excludeTarget(R.id.container, true)

        detailsFragment.returnTransition = Fade()
            .excludeTarget(R.id.container, true)
            .setDuration(baseDurationMs)

        detailsFragment.sharedElementEnterTransition = TransitionSet()
            .setDuration(baseDurationMs)
            .setStartDelay(baseDurationMs)
            .addTransition(ChangeBounds())
            .setInterpolator(FastOutSlowInInterpolator())

        detailsFragment.sharedElementReturnTransition = TransitionSet()
            .addTransition(ChangeBounds())
            .setStartDelay(baseDurationMs)
            .setInterpolator(FastOutSlowInInterpolator())

        activity!!.supportFragmentManager
            .beginTransaction()
            .setReorderingAllowed(true)
            .addSharedElement(sharedElement, "cardContainer_$creditCardId")
            .replace(R.id.container, detailsFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun getCardById(creditCardId: String) = sampleCards.first { it.id == creditCardId }

}

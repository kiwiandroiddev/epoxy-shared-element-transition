package com.example.epoxysharedelementtransition


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.epoxysharedelementtransition.listController.CreditCardDetailsController
import com.example.epoxysharedelementtransition.model.CreditCard
import java.util.concurrent.TimeUnit

class CardDetailsFragment : Fragment() {

    lateinit var epoxyRecyclerView: EpoxyRecyclerView

    private val detailsController = CreditCardDetailsController()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_card_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postponeEnterTransition(3000, TimeUnit.MILLISECONDS)

        epoxyRecyclerView = view.findViewById(R.id.epoxy_recycler_view)
        epoxyRecyclerView.layoutManager = LinearLayoutManager(context)
        epoxyRecyclerView.setController(detailsController)
        epoxyRecyclerView.itemAnimator = null

        loadCardDetailsAfterArtificialDelay()
    }

    private fun loadCardDetailsAfterArtificialDelay() {
        Handler().postDelayed({
            detailsController.setData(getCard())
            epoxyRecyclerView.viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }, 300)
    }

    private fun getCard(): CreditCard {
        return arguments!!.getSerializable(ARG_CARD) as CreditCard
    }

    companion object {
        private const val ARG_CARD = "card_arg"

        fun newInstance(card: CreditCard): CardDetailsFragment {
            return CardDetailsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CARD, card)
                }
            }
        }
    }

}


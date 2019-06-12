package com.example.epoxysharedelementtransition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.epoxysharedelementtransition.listController.MyCreditCardsController
import com.example.epoxysharedelementtransition.model.CreditCard

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()

        private val sampleCards = listOf(
            CreditCard(id = "001", cardNumber = "**** **** **** 0231", fullName = "John Doe", expiryDate = "06/22"),
            CreditCard(id = "002", cardNumber = "**** **** **** 8093", fullName = "Mr. John M. Doe", expiryDate = "03/20"),
            CreditCard(id = "003", cardNumber = "**** **** **** 3001", fullName = "JOHN DOE", expiryDate = "12/21")
        )
    }

    private val listController = MyCreditCardsController()

    lateinit var epoxyRecyclerView: EpoxyRecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        epoxyRecyclerView = view.findViewById(R.id.epoxy_recycler_view)
        epoxyRecyclerView.layoutManager = LinearLayoutManager(context)
        epoxyRecyclerView.setController(listController)

        listController.setData(sampleCards)
    }

}

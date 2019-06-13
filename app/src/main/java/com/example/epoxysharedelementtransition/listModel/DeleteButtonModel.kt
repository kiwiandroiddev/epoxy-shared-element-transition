package com.example.epoxysharedelementtransition.listModel

import com.airbnb.epoxy.EpoxyModelClass
import com.example.epoxysharedelementtransition.R

@Suppress("LeakingThis")
@EpoxyModelClass
abstract class DeleteButtonModel : EpoxyModelWithLayout(R.layout.list_item_delete_button) {

    init { id("delete_button") }

}
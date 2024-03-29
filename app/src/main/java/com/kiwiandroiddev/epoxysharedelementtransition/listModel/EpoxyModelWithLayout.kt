package com.kiwiandroiddev.epoxysharedelementtransition.listModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.airbnb.epoxy.EpoxyModelWithView

abstract class EpoxyModelWithLayout(@LayoutRes private val layoutResId: Int) : EpoxyModelWithView<View>() {

    final override fun buildView(parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)
        return inflater.inflate(layoutResId, parent, false)
    }

}
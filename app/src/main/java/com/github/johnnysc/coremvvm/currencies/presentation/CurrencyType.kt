package com.github.johnnysc.coremvvm.currencies.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUiType

/**
 * @author Asatryan on 02.06.2022
 */
object CurrencyType : ItemUiType {

    override fun viewHolder(parent: ViewGroup) = CurrencyViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.currency_layout, parent, false)
    )
}
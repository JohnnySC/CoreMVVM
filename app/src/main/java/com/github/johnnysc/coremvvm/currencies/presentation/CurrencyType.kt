package com.github.johnnysc.coremvvm.currencies.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi

/**
 * @author Asatryan on 02.06.2022
 */
object CurrencyType : CurrencyItemUiType {

    override fun viewHolder(
        parent: ViewGroup,
    ): GenericViewHolder<ItemUi> = CurrencyViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.currency_layout, parent, false)
    )
}

object CurrencyTypeClickable : CurrencyItemUiTypeClickable {

    override fun viewHolder(
        parent: ViewGroup,
        clickListener: CurrenciesClickListener
    ): GenericViewHolder<ItemUi> = CurrencyViewHolderClickable(
        clickListener,
        LayoutInflater.from(parent.context)
            .inflate(R.layout.currency_layout, parent, false)
    )
}
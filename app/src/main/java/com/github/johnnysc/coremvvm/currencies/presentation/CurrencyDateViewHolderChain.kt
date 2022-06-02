package com.github.johnnysc.coremvvm.currencies.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.ViewHolderFactoryChain

/**
 * @author Asatryan on 02.06.2022
 */
class CurrencyDateViewHolderChain(
    private val viewHolderFactoryChain: ViewHolderFactoryChain<ItemUi>
) : ViewHolderFactoryChain<ItemUi> {

    override fun viewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<ItemUi> =
        if (viewType == 2)
            CurrencyDateViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.currency_date_layout, parent, false)
            )
        else viewHolderFactoryChain.viewHolder(parent, viewType)
}
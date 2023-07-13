package com.github.johnnysc.coremvvm.currencies.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.johnnysc.coremvvm.R

/**
 * @author Asatryan on 02.06.2022
 */
object CurrencyDateType : CurrencyItemUiType {

    override fun viewHolder(parent: ViewGroup) = CurrencyDateViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.currency_date_layout, parent, false)
    )
}
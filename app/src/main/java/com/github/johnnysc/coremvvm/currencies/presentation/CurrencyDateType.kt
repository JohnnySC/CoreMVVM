package com.github.johnnysc.coremvvm.currencies.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUiType
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

/**
 * @author Asatryan on 02.06.2022
 */
abstract class CurrencyDateType : ItemUiType<MyView, CurrencyItemUi> {

    protected fun view(parent: ViewGroup): View = LayoutInflater.from(parent.context)
        .inflate(R.layout.currency_date_layout, parent, false)

    object Base : CurrencyDateType(), CurrencyItemUiType.Base {

        override fun viewHolder(parent: ViewGroup) = CurrencyDateViewHolder.Base(view(parent))
    }

    object Clickable : CurrencyDateType(), CurrencyItemUiType.Clickable {

        override fun viewHolder(
            parent: ViewGroup,
            clickListener: CurrenciesClickListener
        ) = CurrencyDateViewHolder.Clickable(clickListener, view(parent))
    }
}

abstract class CurrencyDateTypeCombo : ItemUiType<MyView, CurrencyItemUi> {

    protected fun view(parent: ViewGroup): View = LayoutInflater.from(parent.context)
        .inflate(R.layout.currency_date_layout, parent, false)

    object Base : CurrencyDateTypeCombo(),
        ItemUiType.Combo<MyView, CurrencyItemUi, CurrenciesClickListener> {

        override fun clickable() = false

        override fun viewHolder(parent: ViewGroup) = CurrencyDateViewHolder.Base(view(parent))
    }

    object Clickable : CurrencyDateTypeCombo(),
        ItemUiType.Combo<MyView, CurrencyItemUi, CurrenciesClickListener> {

        override fun clickable() = true

        override fun viewHolder(
            parent: ViewGroup,
            clickListener: CurrenciesClickListener
        ) = CurrencyDateViewHolder.Clickable(clickListener, view(parent))
    }
}
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
abstract class CurrencyType : ItemUiType<MyView, CurrencyItemUi> {

    protected fun view(parent: ViewGroup): View = LayoutInflater.from(parent.context)
        .inflate(R.layout.currency_layout, parent, false)

    object Base : CurrencyType(), CurrencyItemUiType.Base {
        override fun viewHolder(parent: ViewGroup) = CurrencyViewHolder.Base(view(parent))
    }

    object Clickable : CurrencyType(), CurrencyItemUiType.Clickable {
        override fun viewHolder(
            parent: ViewGroup,
            clickListener: CurrenciesClickListener
        ) = CurrencyViewHolder.Clickable(clickListener, view(parent))
    }
}

abstract class CurrencyTypeCombo : ItemUiType<MyView, CurrencyItemUi> {

    protected fun view(parent: ViewGroup): View = LayoutInflater.from(parent.context)
        .inflate(R.layout.currency_layout, parent, false)

    object Base : CurrencyTypeCombo(), ItemUiType.Combo<MyView, CurrencyItemUi, CurrenciesClickListener> {
        override fun clickable() = false
        override fun viewHolder(parent: ViewGroup) = CurrencyViewHolder.Base(view(parent))
    }

    object Clickable : CurrencyTypeCombo(), ItemUiType.Combo<MyView, CurrencyItemUi, CurrenciesClickListener> {
        override fun clickable() = true
        override fun viewHolder(
            parent: ViewGroup,
            clickListener: CurrenciesClickListener
        ) = CurrencyViewHolder.Clickable(clickListener, view(parent))
    }
}
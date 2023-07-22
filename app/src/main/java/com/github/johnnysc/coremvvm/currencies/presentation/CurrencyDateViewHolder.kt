package com.github.johnnysc.coremvvm.currencies.presentation

import android.view.View
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi

/**
 * @author Asatryan on 02.06.2022
 */
abstract class CurrencyDateViewHolder(view: View) : GenericViewHolder<CurrencyItemUi>(view) {

    override fun bind(item: CurrencyItemUi) =
        item.show(itemView.findViewById(R.id.dateTextView))

    class Base(view: View) : CurrencyDateViewHolder(view)

    class Clickable(
        private val clickListener: CurrenciesClickListener,
        view: View
    ) : CurrencyDateViewHolder(view) {

        override fun bind(item: CurrencyItemUi) {
            super.bind(item)
            itemView.setOnClickListener {
                item.handleClick(clickListener)
            }
        }
    }
}

interface CurrencyItemUi : ItemUi {

    fun handleClick(clickListener: CurrenciesClickListener) = Unit
}
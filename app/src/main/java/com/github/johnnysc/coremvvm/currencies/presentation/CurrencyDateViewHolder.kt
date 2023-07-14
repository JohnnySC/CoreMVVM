package com.github.johnnysc.coremvvm.currencies.presentation

import android.view.View
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi

/**
 * @author Asatryan on 02.06.2022
 */
class CurrencyDateViewHolder(
    view: View
) : GenericViewHolder<ItemUi>(view) {

    override fun bind(item: ItemUi) = item.show(itemView.findViewById(R.id.dateTextView))
}

class CurrencyDateViewHolderClickable(
    private val clickListener: CurrenciesClickListener,
    view: View
) : GenericViewHolder<ItemUi>(view) {

    override fun bind(item: ItemUi) {
        itemView.setOnClickListener {
            clickListener.show(item.toString())
        }
        item.show(itemView.findViewById(R.id.dateTextView))
    }
}
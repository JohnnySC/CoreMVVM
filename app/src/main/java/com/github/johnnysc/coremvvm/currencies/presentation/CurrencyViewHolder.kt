package com.github.johnnysc.coremvvm.currencies.presentation

import android.view.View
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi

/**
 * @author Asatryan on 02.06.2022
 */
abstract class CurrencyViewHolder(view: View) : GenericViewHolder<ItemUi>(view) {

    override fun bind(item: ItemUi) = with(itemView) {
        item.show(
            findViewById(R.id.currencyTextView),
            findViewById(R.id.compoundButton)
        )
    }

    class Base(view: View) : CurrencyViewHolder(view)

    class Clickable(
        private val clickListener: CurrenciesClickListener,
        view: View
    ) : CurrencyViewHolder(view) {

        override fun bind(item: ItemUi) {
            super.bind(item)
            itemView.setOnClickListener {
                clickListener.show(item.toString())
            }
        }
    }
}

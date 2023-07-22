package com.github.johnnysc.coremvvm.currencies.presentation

import android.view.View
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

/**
 * @author Asatryan on 02.06.2022
 */
abstract class CurrencyViewHolder(view: View) : GenericViewHolder<MyView, CurrencyItemUi>(view) {

    protected val button: MyView = itemView.findViewById(R.id.compoundButton)
    override fun bind(item: CurrencyItemUi) = with(itemView) {
        item.show(
            findViewById(R.id.currencyTextView),
            button
        )
    }

    class Base(view: View) : CurrencyViewHolder(view)

    class Clickable(
        private val clickListener: CurrenciesClickListener,
        view: View
    ) : CurrencyViewHolder(view) {

        override fun bind(item: CurrencyItemUi) {
            super.bind(item)
            button.handleClick {
                item.handleClick(clickListener)
            }
        }
    }
}

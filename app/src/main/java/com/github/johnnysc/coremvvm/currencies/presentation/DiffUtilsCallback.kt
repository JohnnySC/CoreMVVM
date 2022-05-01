package com.github.johnnysc.coremvvm.currencies.presentation

import androidx.recyclerview.widget.DiffUtil

/**
 * @author Asatryan on 01.05.2022
 */
class DiffUtilsCallback(
    private val oldList: List<CurrencyUi>,
    private val newList: List<CurrencyUi>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].map(CurrencyUi.Mapper.TheSame(newList[newItemPosition]))

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].map(CurrencyUi.Mapper.TheSameContent(newList[newItemPosition]))
}
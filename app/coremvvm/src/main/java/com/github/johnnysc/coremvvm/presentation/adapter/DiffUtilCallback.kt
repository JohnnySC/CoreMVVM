package com.github.johnnysc.coremvvm.presentation.adapter

import androidx.recyclerview.widget.DiffUtil

/**
 * @author Asatryan on 01.06.2022
 */
class DiffUtilCallback<T : ItemUi>(
    private val oldList: List<T>,
    private val newList: List<T>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old: Compare = oldList[oldItemPosition]
        val new: CompareId = newList[newItemPosition]
        return old.same(new)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old: Compare = oldList[oldItemPosition]
        val new: CompareContent = newList[newItemPosition]
        return old.sameContent(new)
    }
}
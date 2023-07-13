package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup

interface ItemUiTypeList<T : ItemUi> : List<ItemUiType<T>> {

    fun viewHolder(index: Int, parent: ViewGroup): GenericViewHolder<T>

    class Base<T : ItemUi>(
        list: List<ItemUiType<T>>
    ) : ArrayList<ItemUiType<T>>(list), ItemUiTypeList<T> {

        override fun viewHolder(index: Int, parent: ViewGroup): GenericViewHolder<T> =
            get(index).viewHolder(parent)
    }
}
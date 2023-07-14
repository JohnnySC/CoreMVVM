package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup

interface ItemUiTypeList<T : ItemUi, E : ItemUiType<T>> : List<E> {

    interface Simple<T : ItemUi> : ItemUiTypeList<T, ItemUiType.Base<T>> {

        fun viewHolder(index: Int, parent: ViewGroup): GenericViewHolder<T>
    }

    interface Clickable<C : ClickListener, T : ItemUi> :
        ItemUiTypeList<T, ItemUiType.Clickable<T, C>> {

        fun viewHolder(index: Int, parent: ViewGroup, clickListener: C): GenericViewHolder<T>
    }

    class Base<T : ItemUi>(
        list: List<ItemUiType.Base<T>>
    ) : ArrayList<ItemUiType.Base<T>>(list), Simple<T> {

        override fun viewHolder(index: Int, parent: ViewGroup) = get(index).viewHolder(parent)
    }

    class WithClickListener<C : ClickListener, T : ItemUi>(
        list: List<ItemUiType.Clickable<T, C>>
    ) : ArrayList<ItemUiType.Clickable<T, C>>(list), Clickable<C, T> {

        override fun viewHolder(
            index: Int,
            parent: ViewGroup,
            clickListener: C
        ): GenericViewHolder<T> = get(index).viewHolder(parent, clickListener)
    }
}
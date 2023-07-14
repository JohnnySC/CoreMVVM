package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup

interface ItemUiTypeList<T : ItemUi, E : ItemUiType<T>> : List<E> {

    interface MakeViewHolder<T : ItemUi> {
        fun viewHolder(index: Int, parent: ViewGroup): GenericViewHolder<T>
    }

    interface MakeClickableViewHolder<T : ItemUi, C : ClickListener> {
        fun viewHolder(index: Int, parent: ViewGroup, clickListener: C): GenericViewHolder<T>
    }

    interface Simple<T : ItemUi> : ItemUiTypeList<T, ItemUiType.Base<T>>, MakeViewHolder<T>

    interface Clickable<C : ClickListener, T : ItemUi> :
        ItemUiTypeList<T, ItemUiType.Clickable<T, C>>, MakeClickableViewHolder<T, C>

    interface Combined<C : ClickListener, T : ItemUi> : ItemUiTypeList<T, ItemUiType.Combo<T, C>>,
        MakeViewHolder<T>, MakeClickableViewHolder<T, C>

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

    class Combo<C : ClickListener, T : ItemUi>(
        list: List<ItemUiType.Combo<T, C>>
    ) : ArrayList<ItemUiType.Combo<T, C>>(list), Combined<C, T> {

        override fun viewHolder(index: Int, parent: ViewGroup, clickListener: C) =
            get(index).viewHolder(parent, clickListener)

        override fun viewHolder(index: Int, parent: ViewGroup) = get(index).viewHolder(parent)
    }
}
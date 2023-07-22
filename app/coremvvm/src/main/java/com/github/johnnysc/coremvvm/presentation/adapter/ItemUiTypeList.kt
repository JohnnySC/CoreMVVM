package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup

interface ItemUiTypeList<V : MyView, T : ItemUi<V>, E : ItemUiType<V, T>> : List<E> {

    interface MakeViewHolder<V : MyView, T : ItemUi<V>> {
        fun viewHolder(index: Int, parent: ViewGroup): GenericViewHolder<V, T>
    }

    interface MakeClickableViewHolder<V : MyView, T : ItemUi<V>, C : ClickListener> {
        fun viewHolder(index: Int, parent: ViewGroup, clickListener: C): GenericViewHolder<V, T>
    }

    interface Simple<V : MyView, T : ItemUi<V>> : ItemUiTypeList<V, T, ItemUiType.Base<V, T>>,
        MakeViewHolder<V, T>

    interface Clickable<C : ClickListener, V : MyView, T : ItemUi<V>> :
        ItemUiTypeList<V, T, ItemUiType.Clickable<V, T, C>>, MakeClickableViewHolder<V, T, C>

    interface Combined<C : ClickListener, V : MyView, T : ItemUi<V>> :
        ItemUiTypeList<V, T, ItemUiType.Combo<V, T, C>>,
        MakeViewHolder<V, T>, MakeClickableViewHolder<V, T, C>

    class Base<V : MyView, T : ItemUi<V>>(
        list: List<ItemUiType.Base<V, T>>
    ) : ArrayList<ItemUiType.Base<V, T>>(list), Simple<V, T> {

        override fun viewHolder(index: Int, parent: ViewGroup) = get(index).viewHolder(parent)
    }

    class WithClickListener<C : ClickListener, V : MyView, T : ItemUi<V>>(
        list: List<ItemUiType.Clickable<V, T, C>>
    ) : ArrayList<ItemUiType.Clickable<V, T, C>>(list), Clickable<C, V, T> {

        override fun viewHolder(
            index: Int,
            parent: ViewGroup,
            clickListener: C
        ): GenericViewHolder<V, T> = get(index).viewHolder(parent, clickListener)
    }

    class Combo<C : ClickListener, V : MyView, T : ItemUi<V>>(
        list: List<ItemUiType.Combo<V, T, C>>
    ) : ArrayList<ItemUiType.Combo<V, T, C>>(list), Combined<C, V, T> {

        override fun viewHolder(index: Int, parent: ViewGroup, clickListener: C) =
            get(index).viewHolder(parent, clickListener)

        override fun viewHolder(index: Int, parent: ViewGroup) = get(index).viewHolder(parent)
    }
}
package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup

interface ItemUiType<V : MyView, T : ItemUi<V>> {

    fun clickable(): Boolean

    interface MakeViewHolder<V : MyView, T : ItemUi<V>> {

        fun viewHolder(parent: ViewGroup): GenericViewHolder<V, T>
    }

    interface MakeViewHolderClickable<V : MyView, T : ItemUi<V>, C : ClickListener> {

        fun viewHolder(parent: ViewGroup, clickListener: C): GenericViewHolder<V, T>
    }

    interface Base<V : MyView, T : ItemUi<V>> : ItemUiType<V, T>, MakeViewHolder<V, T> {

        override fun clickable() = false
    }

    interface Clickable<V : MyView, T : ItemUi<V>, C : ClickListener> : ItemUiType<V, T>,
        MakeViewHolderClickable<V, T, C> {

        override fun clickable() = true
    }

    interface Combo<V : MyView, T : ItemUi<V>, C : ClickListener> : ItemUiType<V, T>,
        MakeViewHolder<V, T>,
        MakeViewHolderClickable<V, T, C> {

        override fun viewHolder(parent: ViewGroup): GenericViewHolder<V, T> =
            throw IllegalStateException("override to use if not clickable")

        override fun viewHolder(parent: ViewGroup, clickListener: C): GenericViewHolder<V, T> =
            throw IllegalStateException("override to use if clickable")
    }
}
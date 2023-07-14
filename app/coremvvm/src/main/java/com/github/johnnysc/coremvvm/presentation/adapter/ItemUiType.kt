package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup

interface ItemUiType<T : ItemUi> {

    fun clickable(): Boolean

    interface MakeViewHolder<T : ItemUi> {

        fun viewHolder(parent: ViewGroup): GenericViewHolder<T>
    }

    interface MakeViewHolderClickable<T : ItemUi, C : ClickListener> {

        fun viewHolder(parent: ViewGroup, clickListener: C): GenericViewHolder<T>
    }

    interface Base<T : ItemUi> : ItemUiType<T>, MakeViewHolder<T> {

        override fun clickable() = false
    }

    interface Clickable<T : ItemUi, C : ClickListener> : ItemUiType<T>,
        MakeViewHolderClickable<T, C> {

        override fun clickable() = true
    }

    interface Combo<T : ItemUi, C : ClickListener> : ItemUiType<T>, MakeViewHolder<T>,
        MakeViewHolderClickable<T, C> {

        override fun viewHolder(parent: ViewGroup): GenericViewHolder<T> =
            throw IllegalStateException("override to use if not clickable")

        override fun viewHolder(parent: ViewGroup, clickListener: C): GenericViewHolder<T> =
            throw IllegalStateException("override to use if clickable")
    }
}
package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup

interface ItemUiType<T : ItemUi> {

    interface Base<T : ItemUi> : ItemUiType<T> {

        fun viewHolder(parent: ViewGroup): GenericViewHolder<T>
    }

    interface Clickable<T : ItemUi, C : ClickListener> : ItemUiType<T> {

        fun viewHolder(parent: ViewGroup, clickListener: C): GenericViewHolder<T>
    }
}
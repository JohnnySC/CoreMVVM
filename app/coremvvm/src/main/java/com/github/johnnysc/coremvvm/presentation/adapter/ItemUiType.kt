package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup

interface ItemUiType<T : ItemUi> {

    fun viewHolder(parent: ViewGroup): GenericViewHolder<T>
}
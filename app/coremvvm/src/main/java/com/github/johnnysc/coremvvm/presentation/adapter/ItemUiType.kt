package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup

interface ItemUiType {

    fun viewHolder(parent: ViewGroup): GenericViewHolder<*>
}
package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Asatryan on 01.06.2022
 */
abstract class GenericViewHolder<V : MyView, T : ItemUi<V>>(view: View) :
    RecyclerView.ViewHolder(view) {

    abstract fun bind(item: T)
}
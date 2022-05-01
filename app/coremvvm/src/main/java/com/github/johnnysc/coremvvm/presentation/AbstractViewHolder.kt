package com.github.johnnysc.coremvvm.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Asatryan on 01.05.2022
 */
abstract class AbstractViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(data: T)
}
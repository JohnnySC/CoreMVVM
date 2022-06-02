package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup
import java.lang.IllegalStateException

/**
 * @author Asatryan on 01.06.2022
 */
interface ViewHolderFactoryChain<T : ItemUi> {

    fun viewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T>

    class Exception<T : ItemUi> : ViewHolderFactoryChain<T> {
        override fun viewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
            throw IllegalStateException("unknown viewType $viewType")
        }
    }
}
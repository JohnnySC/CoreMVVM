package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.johnnysc.coremvvm.core.Mapper

/**
 * @author Asatryan on 01.06.2022
 */
abstract class GenericAdapter<T : ItemUi>(
    private val viewHolderFactoryChain: ViewHolderFactoryChain<T>
) : RecyclerView.Adapter<GenericViewHolder<T>>(), Mapper.Unit<List<T>> {

    private val list: MutableList<T> = mutableListOf()

    override fun getItemViewType(position: Int): Int = list[position].type()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> =
        viewHolderFactoryChain.viewHolder(parent, viewType)

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    override fun map(data: List<T>) {
        val diffCallback = DiffUtilCallback(list, data)
        val result = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(data)
        result.dispatchUpdatesTo(this)
    }

    class Base(viewHolderFactoryChain: ViewHolderFactoryChain<ItemUi>) :
        GenericAdapter<ItemUi>(viewHolderFactoryChain)
}
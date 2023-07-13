package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.johnnysc.coremvvm.core.Mapper

/**
 * @author Asatryan on 01.06.2022
 */
abstract class GenericAdapter<T : ItemUi>(
    private val typeList: List<ItemUiType>
) : RecyclerView.Adapter<GenericViewHolder<T>>(), Mapper.Unit<List<T>> {

    init {
        if (typeList.isEmpty())
            throw IllegalStateException("TypeList cannot be empty! Please provide types.")
    }

    private val list: MutableList<T> = mutableListOf()

    override fun getItemViewType(position: Int): Int {
        val type = list[position].type()
        val index = typeList.indexOf(type)
        if (index == -1)
            throw IllegalStateException("Type $type is not included in the typeList $typeList")
        return index
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        typeList[viewType].viewHolder(parent) as GenericViewHolder<T>

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

    abstract class Base(typeList: List<ItemUiType>) : GenericAdapter<ItemUi>(typeList)
}
package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.johnnysc.coremvvm.core.Mapper
import kotlin.math.abs

/**
 * @author Asatryan on 01.06.2022
 */
abstract class GenericAdapter<R : ItemUiType<V, T>, E : ItemUiTypeList<V, T, R>, V : MyView, T : ItemUi<V>>(
    protected val typeList: E
) : RecyclerView.Adapter<GenericViewHolder<V, T>>(), Mapper.Unit<List<T>> {

    init {
        if (typeList.isEmpty())
            throw IllegalStateException("TypeList cannot be empty! Please provide types.")
    }

    protected val list: MutableList<T> = mutableListOf()

    override fun getItemViewType(position: Int): Int {
        val type = list[position].type()
        val index = typeList.indexOf(type)
        if (index == -1)
            throw IllegalStateException("Type $type is not included in the typeList $typeList")
        return index
    }

    override fun onBindViewHolder(holder: GenericViewHolder<V, T>, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    override fun map(data: List<T>) {
        val diffCallback = DiffUtilCallback(list, data)
        val result = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(data)
        result.dispatchUpdatesTo(this)
    }

    /**
     * Adapter with items all not clickable
     */
    abstract class Simple<V : MyView, T : ItemUi<V>>(
        typeList: ItemUiTypeList.Simple<V, T>
    ) : GenericAdapter<ItemUiType.Base<V, T>, ItemUiTypeList.Simple<V, T>, V, T>(
        typeList
    ) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<V, T> =
            typeList.viewHolder(viewType, parent)
    }

    /**
     * Adapter with items all clickable
     */
    abstract class WithClicks<C : ClickListener, V : MyView, T : ItemUi<V>>(
        private val clickListener: C,
        typeList: ItemUiTypeList.Clickable<C, V, T>
    ) : GenericAdapter<ItemUiType.Clickable<V, T, C>, ItemUiTypeList.Clickable<C, V, T>, V, T>(
        typeList
    ) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<V, T> =
            typeList.viewHolder(viewType, parent, clickListener)
    }

    /**
     * Adapter with items both clickable and not clickable
     */
    abstract class Combo<C : ClickListener, V : MyView, T : ItemUi<V>>(
        private val clickListener: C,
        typeList: List<ItemUiType.Combo<V, T, C>>,
        private val clickableIndex: ClickableIndex = ClickableIndex.Base()
    ) : GenericAdapter<ItemUiType.Combo<V, T, C>, ItemUiTypeList.Combined<C, V, T>, V, T>(
        ItemUiTypeList.Combo(typeList)
    ) {

        override fun getItemViewType(position: Int): Int {
            val type = list[position].type()
            val index = typeList.indexOf(type)
            if (index == -1)
                throw IllegalStateException("Type $type is not included in the typeList $typeList")
            return if (type.clickable()) clickableIndex.encode(index) else index
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if (viewType < 0)
            typeList.viewHolder(clickableIndex.decode(viewType), parent, clickListener)
        else
            typeList.viewHolder(viewType, parent)
    }
}

interface ClickListener

interface ClickableIndex {

    fun encode(index: Int): Int

    fun decode(index: Int): Int

    class Base(
        private val sourceIndexCornerCase: Int = 0,
        private val targetIndexCornerCase: Int = Integer.MIN_VALUE
    ) : ClickableIndex {

        override fun encode(index: Int) = if (index == sourceIndexCornerCase)
            targetIndexCornerCase
        else
            -1 * index

        override fun decode(index: Int) = if (index == targetIndexCornerCase)
            sourceIndexCornerCase
        else
            abs(index)
    }
}
package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.johnnysc.coremvvm.core.Mapper
import kotlin.math.abs

/**
 * @author Asatryan on 01.06.2022
 */
abstract class GenericAdapter<R : ItemUiType<T>, E : ItemUiTypeList<T, R>, T : ItemUi>(
    protected val typeList: E
) : RecyclerView.Adapter<GenericViewHolder<T>>(), Mapper.Unit<List<T>> {

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

    /**
     * Adapter with items all not clickable
     */
    abstract class Simple<T : ItemUi>(
        typeList: ItemUiTypeList.Simple<T>
    ) : GenericAdapter<ItemUiType.Base<T>, ItemUiTypeList.Simple<T>, T>(
        typeList
    ) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> =
            typeList.viewHolder(viewType, parent)
    }

    /**
     * Adapter with items all clickable
     */
    abstract class WithClicks<C : ClickListener, T : ItemUi>(
        private val clickListener: C,
        typeList: ItemUiTypeList.Clickable<C, T>
    ) : GenericAdapter<ItemUiType.Clickable<T, C>, ItemUiTypeList.Clickable<C, T>, T>(typeList) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> =
            typeList.viewHolder(viewType, parent, clickListener)
    }

    /**
     * Adapter with items both clickable and not clickable
     */
    abstract class Combo<C : ClickListener, T : ItemUi>(
        private val clickListener: C,
        typeList: ItemUiTypeList.Combo<C, T>,
        private val clickableIndex: ClickableIndex = ClickableIndex.Base()
    ) : GenericAdapter<ItemUiType.Combo<T, C>, ItemUiTypeList.Combined<C, T>, T>(typeList) {

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
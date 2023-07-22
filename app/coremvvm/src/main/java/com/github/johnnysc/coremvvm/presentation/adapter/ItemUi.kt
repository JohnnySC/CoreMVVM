package com.github.johnnysc.coremvvm.presentation.adapter

/**
 * @author Asatryan on 01.06.2022
 */
interface ItemUi<T : MyView> : Compare, CompareId, CompareContent {

    fun type(): ItemUiType<*, *>

    fun show(vararg views: T)
}

interface Compare {

    fun same(compareId: CompareId): Boolean

    fun sameContent(compareContent: CompareContent): Boolean
}

interface CompareId {

    fun sameId(id: String): Boolean
}

interface CompareContent {

    fun sameContent(content: String): Boolean
}
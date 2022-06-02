package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.core.Mapper
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi

/**
 * @author Asatryan on 02.06.2022
 */
interface CurrenciesUi : Mapper.Unit<Mapper.Unit<List<ItemUi>>> {

    class Base(private val list: List<ItemUi>) : CurrenciesUi {
        override fun map(data: Mapper.Unit<List<ItemUi>>) = data.map(list)
    }
}
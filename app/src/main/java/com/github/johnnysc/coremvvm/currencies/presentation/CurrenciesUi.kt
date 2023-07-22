package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.core.Mapper

/**
 * @author Asatryan on 02.06.2022
 */
interface CurrenciesUi : Mapper.Unit<Mapper.Unit<List<CurrencyItemUi>>> {

    class Base(private val list: List<CurrencyItemUi>) : CurrenciesUi {
        override fun map(data: Mapper.Unit<List<CurrencyItemUi>>) = data.map(list)
    }
}
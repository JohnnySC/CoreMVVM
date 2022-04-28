package com.github.johnnysc.coremvvm.currencies.data

/**
 * @author Asatryan on 26.04.2022
 */
interface CurrenciesCache {

    interface Save : com.github.johnnysc.coremvvm.core.Save<CurrenciesCloud>
    interface Read : com.github.johnnysc.coremvvm.core.Read<CurrenciesCloud>

    interface Mutable : Save, Read

    class Base(private var data: CurrenciesCloud = CurrenciesCloud.Empty()) : Mutable {

        override fun save(data: CurrenciesCloud) {
            this.data = data
        }

        override fun read(): CurrenciesCloud = data
    }
}
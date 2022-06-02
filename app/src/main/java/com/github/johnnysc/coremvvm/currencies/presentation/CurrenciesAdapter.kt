package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.GenericAdapter
import com.github.johnnysc.coremvvm.presentation.adapter.ViewHolderFactoryChain

/**
 * @author Asatryan on 02.06.2022
 */
interface CurrenciesAdapter {

    class Currencies :
        GenericAdapter.Base(
            CurrencyViewHolderFactoryChain(
                CurrencyDateViewHolderChain(
                    ViewHolderFactoryChain.Exception()
                )
            )
        )

    class Favorites : GenericAdapter.Base(
        CurrencyViewHolderFactoryChain(
            ViewHolderFactoryChain.Exception()
        )
    )
}
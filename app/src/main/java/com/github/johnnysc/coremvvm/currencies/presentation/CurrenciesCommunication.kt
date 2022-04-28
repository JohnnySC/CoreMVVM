package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.Communication

/**
 * @author Asatryan on 26.04.2022
 */
interface CurrenciesCommunication : Communication.Mutable<CurrenciesUi> {
    class Base : Communication.UiUpdate<CurrenciesUi>(), CurrenciesCommunication
}
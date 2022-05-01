package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.currencies.domain.CurrenciesInteractor
import com.github.johnnysc.coremvvm.presentation.*

/**
 * @author Asatryan on 26.04.2022
 */
class CurrenciesViewModel(
    canGoBackCallback: CanGoBack.Callback,
    private val interactor: CurrenciesInteractor,
    progressCommunication: ProgressCommunication.Update,
    communication: CurrenciesCommunication,
    dispatchers: Dispatchers
) : BackPress.ViewModel<CurrenciesUi>(canGoBackCallback, communication, dispatchers),
    ChangeFavorite {

    private val atFinish = {
        progressCommunication.map(Visibility.Gone())
        canGoBack = true
    }

    private var canGoBack = true

    private val canGoBackCallbackInner = object : CanGoBack {
        override fun canGoBack() = canGoBack
    }

    init {
        canGoBack = false
        progressCommunication.map(Visibility.Visible())
        handle {
            interactor.currencies(atFinish) { communication.map(it) }
        }
    }

    override fun changeFavorite(id: String) = interactor.changeFavorite(id)

    override fun updateCallbacks() =
        canGoBackCallback.updateCallback(canGoBackCallbackInner)
}
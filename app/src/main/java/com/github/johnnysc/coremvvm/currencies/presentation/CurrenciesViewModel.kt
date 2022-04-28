package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.currencies.domain.CurrenciesInteractor
import com.github.johnnysc.coremvvm.presentation.BaseViewModel
import com.github.johnnysc.coremvvm.presentation.ProgressCommunication
import com.github.johnnysc.coremvvm.presentation.Visibility

/**
 * @author Asatryan on 26.04.2022
 */
class CurrenciesViewModel(
    private val interactor: CurrenciesInteractor,
    progressCommunication: ProgressCommunication.Update,
    communication: CurrenciesCommunication,
    dispatchers: Dispatchers
) : BaseViewModel<CurrenciesUi>(communication, dispatchers), ChangeFavorite {

    private val atFinish = { progressCommunication.map(Visibility.Gone()) }

    init {
        progressCommunication.map(Visibility.Visible())
        handle {
            interactor.currencies(atFinish) { communication.map(it) }
        }
    }

    override fun changeFavorite(id: String) = interactor.changeFavorite(id)
}
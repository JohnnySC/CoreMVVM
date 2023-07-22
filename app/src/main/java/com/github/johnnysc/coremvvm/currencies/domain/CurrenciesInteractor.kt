package com.github.johnnysc.coremvvm.currencies.domain

import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.currencies.presentation.ChangeFavorite
import com.github.johnnysc.coremvvm.currencies.presentation.CurrenciesUi
import com.github.johnnysc.coremvvm.data.HandleError
import com.github.johnnysc.coremvvm.domain.Interactor

/**
 * @author Asatryan on 24.04.2022
 */
interface CurrenciesInteractor : ChangeFavorite {

    suspend fun currencies(
        atFinish: () -> Unit,
        successful: (CurrenciesUi) -> Unit
    )

    class Base(
        private val mapper: CurrenciesDomain.Mapper<CurrenciesUi>,
        private val repository: CurrencyRepository,
        dispatchers: Dispatchers,
        handleError: HandleError
    ) : Interactor.Abstract(dispatchers, handleError), CurrenciesInteractor {

        override suspend fun currencies(
            atFinish: () -> Unit,
            successful: (CurrenciesUi) -> Unit,
        ) = handle(successful, atFinish) {
            val data = repository.currencies()
            return@handle data.map(mapper)
        }

        override fun changeFavorite(id: String) = repository.changeFavorite(id)
    }
}
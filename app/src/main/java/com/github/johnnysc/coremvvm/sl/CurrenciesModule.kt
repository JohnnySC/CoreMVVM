package com.github.johnnysc.coremvvm.sl

import com.github.johnnysc.coremvvm.currencies.data.*
import com.github.johnnysc.coremvvm.currencies.domain.CurrenciesDomain
import com.github.johnnysc.coremvvm.currencies.domain.CurrenciesInteractor
import com.github.johnnysc.coremvvm.currencies.presentation.CurrenciesCommunication
import com.github.johnnysc.coremvvm.currencies.presentation.CurrenciesViewModel
import com.github.johnnysc.coremvvm.domain.HandleDomainError
import com.github.johnnysc.coremvvm.presentation.HandleUiError

/**
 * @author Asatryan on 26.04.2022
 */
class CurrenciesModule(
    private val coreModule: CoreModule,
    private val favorites: FavoritesCacheDataSource,
    private val cache: CurrenciesCache.Save,
) : Module<CurrenciesViewModel> {

    override fun viewModel(): CurrenciesViewModel {
        val repository = BaseCurrencyRepository(
            favorites,
            cache,
            CurrenciesCloudDataSource.Base(
                ProvideCurrencyService.Base(coreModule).currencyService(),
                HandleDomainError()
            ),
            CurrenciesCloud.Mapper.Base()
        )
        return CurrenciesViewModel(
            coreModule.provideCanGoBack(),
            CurrenciesInteractor.Base(
                CurrenciesDomain.Mapper.Base(favorites, repository),
                repository,
                coreModule.dispatchers(),
                HandleUiError(coreModule, coreModule.provideGlobalErrorCommunication())
            ),
            coreModule.provideProgressCommunication(),
            CurrenciesCommunication.Base(),
            coreModule.dispatchers()
        )
    }
}
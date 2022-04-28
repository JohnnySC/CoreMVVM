package com.github.johnnysc.coremvvm.sl

import com.github.johnnysc.coremvvm.currencies.data.CurrenciesCache
import com.github.johnnysc.coremvvm.currencies.data.FavoritesCacheDataSource
import com.github.johnnysc.coremvvm.favorites.data.FavoriteMapper
import com.github.johnnysc.coremvvm.favorites.data.FavoritesRepository
import com.github.johnnysc.coremvvm.favorites.presentation.FavoritesCommunication
import com.github.johnnysc.coremvvm.favorites.presentation.FavoritesViewModel

/**
 * @author Asatryan on 26.04.2022
 */
class FavoritesModule(
    private val coreModule: CoreModule,
    private val cacheDataSource: FavoritesCacheDataSource,
    private val cache: CurrenciesCache.Read
) : Module<FavoritesViewModel> {

    override fun viewModel() = FavoritesViewModel(
        FavoritesRepository.Base(cache, cacheDataSource, FavoriteMapper.Base(cacheDataSource)),
        FavoritesCommunication.Base(),
        coreModule.dispatchers()
    )
}
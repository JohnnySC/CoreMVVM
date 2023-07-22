package com.github.johnnysc.coremvvm.sl

import com.github.johnnysc.coremvvm.currencies.data.CurrenciesCache
import com.github.johnnysc.coremvvm.currencies.data.FavoritesCacheDataSource
import com.github.johnnysc.coremvvm.currencies.presentation.ChangeFavorite
import com.github.johnnysc.coremvvm.favorites.data.FavoriteMapper
import com.github.johnnysc.coremvvm.favorites.data.FavoritesRepository
import com.github.johnnysc.coremvvm.favorites.presentation.FavoritesCommunication
import com.github.johnnysc.coremvvm.favorites.presentation.FavoritesViewModel
import com.github.johnnysc.coremvvm.favorites.presentation.UpdateFavorites

/**
 * @author Asatryan on 26.04.2022
 */
class FavoritesModule(
    private val coreModule: CoreModule,
    private val cacheDataSource: FavoritesCacheDataSource,
    private val cache: CurrenciesCache.Read
) : Module<FavoritesViewModel> {

    override fun viewModel(): FavoritesViewModel {
        val communication = FavoritesCommunication.Base()
        val update = UpdateFavorites.Base()
        return FavoritesViewModel(
            ChangeFavorite.Combo(cacheDataSource, update),
            update,
            FavoritesRepository.Base(
                cache,
                FavoriteMapper.Base(cacheDataSource)
            ),
            communication,
            coreModule.dispatchers()
        )
    }
}
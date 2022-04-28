package com.github.johnnysc.coremvvm.currencies.data

import com.github.johnnysc.coremvvm.currencies.domain.CurrenciesDomain
import com.github.johnnysc.coremvvm.currencies.domain.CurrencyRepository

/**
 * @author Asatryan on 24.04.2022
 */
class BaseCurrencyRepository(
    private val cacheDataSource: FavoritesCacheDataSource,
    private val cache: CurrenciesCache.Save,
    private val cloudDataSource: CurrenciesCloudDataSource,
    private val mapper: CurrenciesCloud.Mapper<CurrenciesDomain>
) : CurrencyRepository {

    override suspend fun currencies(): CurrenciesDomain {
        val currencies = cloudDataSource.latestCurrencies()
        cache.save(currencies)
        return currencies.map(mapper)
    }

    override fun changeFavorite(id: String) = cacheDataSource.changeFavorite(id)
}
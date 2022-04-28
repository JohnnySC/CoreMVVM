package com.github.johnnysc.coremvvm.currencies.data

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Asatryan on 24.04.2022
 */
interface CurrencyService {

    @GET("api/latest")
    suspend fun currencies(//todo think about security of this key
        @Query("access_key") accessKey: String = "b1f6bbc65654436995edda916fe31f06"
    ) : CurrenciesCloud.Base
}
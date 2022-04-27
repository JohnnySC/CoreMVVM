package com.github.johnnysc.coremvvm.data

/**
 * @author Asatryan on 24.04.2022
 */
interface MakeService {

    fun <T> service(clasz: Class<T>): T

    abstract class Abstract(
        private val retrofitBuilder: ProvideRetrofitBuilder,
    ) : MakeService {

        private val retrofit by lazy {
            retrofitBuilder.provideRetrofitBuilder()
                .baseUrl(baseUrl())
                .build()
        }

        override fun <T> service(clasz: Class<T>): T = retrofit.create(clasz)

        protected open fun baseUrl(): String = "https://www.google.com"
    }
}
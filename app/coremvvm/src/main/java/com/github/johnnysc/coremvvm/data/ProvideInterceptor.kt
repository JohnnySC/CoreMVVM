package com.github.johnnysc.coremvvm.data

import okhttp3.logging.HttpLoggingInterceptor

/**
 * @author Asatryan on 24.04.2022
 */
interface ProvideInterceptor {

    fun interceptor(): HttpLoggingInterceptor

    abstract class Abstract(
        private val loggingLevel: HttpLoggingInterceptor.Level
    ) : ProvideInterceptor {

        override fun interceptor() = HttpLoggingInterceptor().apply {
            level = loggingLevel
        }
    }

    class Debug : Abstract(HttpLoggingInterceptor.Level.BODY)

    class Release : Abstract(HttpLoggingInterceptor.Level.NONE)
}
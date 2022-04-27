package com.github.johnnysc.coremvvm.data

import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Asatryan on 24.04.2022
 */
interface ProvideConverterFactory {

    fun converterFactory(): Converter.Factory

    class Base : ProvideConverterFactory {

        override fun converterFactory(): Converter.Factory = GsonConverterFactory.create()
    }
}
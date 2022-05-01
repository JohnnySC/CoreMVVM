package com.github.johnnysc.coremvvm.sl

import android.content.Context
import android.content.SharedPreferences
import com.github.johnnysc.coremvvm.BuildConfig
import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.core.ManageResources
import com.github.johnnysc.coremvvm.data.ProvideConverterFactory
import com.github.johnnysc.coremvvm.data.ProvideInterceptor
import com.github.johnnysc.coremvvm.data.ProvideOkHttpClientBuilder
import com.github.johnnysc.coremvvm.data.ProvideRetrofitBuilder
import com.github.johnnysc.coremvvm.presentation.CanGoBack
import com.github.johnnysc.coremvvm.presentation.GlobalErrorCommunication
import com.github.johnnysc.coremvvm.presentation.ProgressCommunication

/**
 * @author Asatryan on 24.04.2022
 */
interface CoreModule : ManageResources, ProvideDispatchers, ProvideGlobalErrorCommunication,
    ProvideProgressCommunication, ProvideRetrofitBuilder, SharedPrefs, ProvideCanGoBack {

    class Base(private val context: Context) : CoreModule {
        private val dispatchers = Dispatchers.Base()
        private val manageResources = ManageResources.Base(context)

        private val communication = GlobalErrorCommunication.Base()
        private val progress = ProgressCommunication.Base()

        private val canGoBack: CanGoBack.Callback = CanGoBack.Callback.Base()

        private val retrofitBuilder = ProvideRetrofitBuilder.Base(
            ProvideConverterFactory.Base(),
            ProvideOkHttpClientBuilder.Base(
                if (BuildConfig.DEBUG)
                    ProvideInterceptor.Debug()
                else
                    ProvideInterceptor.Release()
            )
        )

        override fun string(id: Int): String = manageResources.string(id)

        override fun dispatchers(): Dispatchers = dispatchers

        override fun provideGlobalErrorCommunication() = communication

        override fun provideProgressCommunication() = progress

        override fun provideRetrofitBuilder() = retrofitBuilder.provideRetrofitBuilder()

        override fun sharedPreferences(key: String): SharedPreferences =
            context.getSharedPreferences(key, Context.MODE_PRIVATE)

        override fun provideCanGoBack(): CanGoBack.Callback = canGoBack

    }
}

interface ProvideDispatchers {

    fun dispatchers(): Dispatchers
}

interface ProvideGlobalErrorCommunication {
    fun provideGlobalErrorCommunication(): GlobalErrorCommunication.Mutable
}

interface ProvideProgressCommunication {

    fun provideProgressCommunication(): ProgressCommunication.Mutable
}

interface SharedPrefs {

    fun sharedPreferences(key: String): SharedPreferences
}

interface ProvideCanGoBack {
    fun provideCanGoBack(): CanGoBack.Callback
}
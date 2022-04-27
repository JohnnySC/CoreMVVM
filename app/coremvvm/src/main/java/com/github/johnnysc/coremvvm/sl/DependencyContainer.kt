package com.github.johnnysc.coremvvm.sl

import androidx.lifecycle.ViewModel

/**
 * @author Asatryan on 24.04.2022
 */
interface DependencyContainer {
    fun <T : ViewModel> module(clazz: Class<T>): Module<*>

    class Error : DependencyContainer {

        override fun <T : ViewModel> module(clazz: Class<T>): Module<*> {
            throw IllegalStateException("no module found for $clazz")
        }
    }
}
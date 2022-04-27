package com.github.johnnysc.coremvvm.sl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner

/**
 * @author Asatryan on 24.04.2022
 */
interface ProvideViewModel {

    fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T
}
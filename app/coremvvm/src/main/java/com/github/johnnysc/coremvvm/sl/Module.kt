package com.github.johnnysc.coremvvm.sl

import androidx.lifecycle.ViewModel

/**
 * @author Asatryan on 24.04.2022
 */
interface Module<T : ViewModel> {

    fun viewModel() : T
}
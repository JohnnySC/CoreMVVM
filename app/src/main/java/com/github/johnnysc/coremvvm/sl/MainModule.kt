package com.github.johnnysc.coremvvm.sl

import com.github.johnnysc.coremvvm.main.presentation.*
import com.github.johnnysc.coremvvm.presentation.NavigationCommunication

/**
 * @author Asatryan on 24.04.2022
 */
class MainModule(private val coreModule: CoreModule) : Module<MainViewModel> {

    override fun viewModel() = MainViewModel(
        coreModule.provideCanGoBack(),
        NavigationCommunication.Base(),
        coreModule.provideProgressCommunication(),
        coreModule.dispatchers(),
        coreModule.provideGlobalErrorCommunication()
    )
}
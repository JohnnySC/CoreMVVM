package com.github.johnnysc.coremvvm.sl

import androidx.lifecycle.ViewModel
import com.github.johnnysc.coremvvm.main.presentation.MainViewModel

/**
 * @author Asatryan on 24.04.2022
 */
class MainDependencyContainer(
    private val dependencyContainer: DependencyContainer,
    private val coreModule: CoreModule
) : DependencyContainer {

    override fun <T : ViewModel> module(clazz: Class<T>): Module<*> =
        if (clazz == MainViewModel::class.java)
            MainModule(coreModule)
        else
            dependencyContainer.module(clazz)
}
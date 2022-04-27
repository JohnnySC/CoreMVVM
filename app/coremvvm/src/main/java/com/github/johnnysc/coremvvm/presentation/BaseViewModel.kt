package com.github.johnnysc.coremvvm.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.johnnysc.coremvvm.core.Dispatchers

/**
 * @author Asatryan on 24.04.2022
 */
abstract class BaseViewModel<T>(
    protected open val communication: Communication.Mutable<T>,
    private val dispatchers: Dispatchers
) : ViewModel(), Communication.Observe<T> {

    override fun observe(owner: LifecycleOwner, observer: Observer<T>) =
        communication.observe(owner, observer)

    protected fun <T> handle(
        block: suspend () -> T
    ) = dispatchers.launchBackground(viewModelScope) {
        block.invoke()
    }
}
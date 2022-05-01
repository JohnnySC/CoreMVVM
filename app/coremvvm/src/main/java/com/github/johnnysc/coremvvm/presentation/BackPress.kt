package com.github.johnnysc.coremvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import com.github.johnnysc.coremvvm.core.Dispatchers

/**
 * @author Asatryan on 02.05.2022
 */
interface BackPress {

    abstract class Activity<T : CanGoBack> : AppCompatActivity() {

        protected lateinit var viewModel: T

        override fun onBackPressed() {
            if (viewModel.canGoBack())
                super.onBackPressed()
        }
    }

    abstract class ActivityViewModel<T>(
        private val canGoBack: CanGoBack,
        communication: Communication.Mutable<T>,
        dispatchers: Dispatchers
    ) : BaseViewModel<T>(
        communication,
        dispatchers
    ), CanGoBack {
        override fun canGoBack(): Boolean = canGoBack.canGoBack()
    }

    abstract class Fragment<C, T : ViewModel<C>> : BaseFragment<T>() {

        override fun onResume() {
            super.onResume()
            viewModel.updateCallbacks()
        }

        override fun onPause() {
            super.onPause()
            viewModel.removeCallbacks()
        }
    }

    abstract class ViewModel<T>(
        protected val canGoBackCallback: CanGoBack.Callback,
        communication: Communication.Mutable<T>,
        dispatchers: Dispatchers
    ) : BaseViewModel<T>(communication, dispatchers), UpdateCallbacks {

        override fun removeCallbacks() = canGoBackCallback.updateCallback(CanGoBack.Empty())
    }
}
package com.github.johnnysc.coremvvm.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.github.johnnysc.coremvvm.sl.ProvideViewModel

/**
 * @author Asatryan on 25.04.2022
 */
abstract class BaseFragment<T : ViewModel> : Fragment() {

    protected lateinit var viewModel: T

    protected abstract fun viewModelClass(): Class<T>

    protected abstract val layoutResId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (requireActivity() as ProvideViewModel).provideViewModel(viewModelClass(), this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = layoutInflater.inflate(layoutResId, container, false)
}
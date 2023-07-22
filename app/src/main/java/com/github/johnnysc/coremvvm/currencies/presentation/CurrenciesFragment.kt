package com.github.johnnysc.coremvvm.currencies.presentation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.presentation.BackPress

/**
 * @author Asatryan on 26.04.2022
 */
class CurrenciesFragment : BackPress.Fragment<CurrenciesUi, CurrenciesViewModel>() {
    override fun viewModelClass() = CurrenciesViewModel::class.java

    override val layoutResId: Int = R.layout.single_recycler_view_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val currenciesAdapter = CurrenciesAdapter.Currencies(viewModel)
        recyclerView.adapter = currenciesAdapter

        viewModel.observe(this) { currenciesUi ->
            currenciesUi.map(currenciesAdapter)
        }
    }
}
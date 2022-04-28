package com.github.johnnysc.coremvvm.currencies.presentation

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.presentation.BaseFragment

/**
 * @author Asatryan on 26.04.2022
 */
class CurrenciesFragment : BaseFragment<CurrenciesViewModel>() {
    override fun viewModelClass() = CurrenciesViewModel::class.java

    override val layoutResId: Int = R.layout.fragment_currencies

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val date = view.findViewById<TextView>(R.id.dateTextView)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val currenciesAdapter = CurrenciesAdapter(viewModel)
        recyclerView.adapter = currenciesAdapter

        viewModel.observe(this) { currenciesUi ->
            currenciesUi.apply(currenciesAdapter)
            currenciesUi.showDate(date)
        }
    }
}
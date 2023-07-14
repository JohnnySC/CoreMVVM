package com.github.johnnysc.coremvvm.favorites.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.currencies.presentation.CurrenciesAdapter
import com.github.johnnysc.coremvvm.currencies.presentation.CurrenciesClickListener
import com.github.johnnysc.coremvvm.presentation.BaseFragment

/**
 * @author Asatryan on 26.04.2022
 */
class FavoritesFragment : BaseFragment<FavoritesViewModel>() {
    override fun viewModelClass() = FavoritesViewModel::class.java

    override val layoutResId = R.layout.single_recycler_view_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val currenciesAdapter = CurrenciesAdapter.Favorites(object : CurrenciesClickListener {
            override fun show(currency: String) {
                Toast.makeText(context, currency, Toast.LENGTH_SHORT).show()
            }
        })
        recyclerView.adapter = currenciesAdapter

        viewModel.observe(this) { favoritesUi ->
            favoritesUi.map(currenciesAdapter)
        }

        viewModel.observeUpdate(this) {
            viewModel.update()
        }
    }
}
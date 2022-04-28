package com.github.johnnysc.coremvvm.currencies.presentation

import android.widget.TextView
import com.github.johnnysc.coremvvm.favorites.presentation.FavoritesUi

/**
 * @author Asatryan on 26.04.2022
 */
interface CurrenciesUi : FavoritesUi, ShowDate {

    class Base(
        list: List<CurrencyUi>,
        private val date: String
    ) : FavoritesUi.Abstract(list), CurrenciesUi{

        override fun showDate(textView: TextView) = textView.setText(date)
    }
}

interface ShowDate {
    fun showDate(textView: TextView)
}
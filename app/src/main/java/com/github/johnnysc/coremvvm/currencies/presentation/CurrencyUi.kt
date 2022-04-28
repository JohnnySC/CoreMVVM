package com.github.johnnysc.coremvvm.currencies.presentation

import android.widget.CompoundButton
import android.widget.TextView

/**
 * @author Asatryan on 26.04.2022
 */
interface CurrencyUi {

    fun apply(textView: TextView, compoundButton: CompoundButton)

    fun changeFavorite(changeFavorite: ChangeFavorite)

    class Base(
        private val id: String,
        private val text: String,
        private val isFavorite: Boolean
    ) : CurrencyUi {

        override fun apply(textView: TextView, compoundButton: CompoundButton) {
            textView.text = text
            compoundButton.isChecked = isFavorite
        }

        override fun changeFavorite(changeFavorite: ChangeFavorite) =
            changeFavorite.changeFavorite(id)
    }
}
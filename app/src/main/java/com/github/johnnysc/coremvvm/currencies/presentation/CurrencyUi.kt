package com.github.johnnysc.coremvvm.currencies.presentation

import android.widget.CompoundButton
import android.widget.TextView

/**
 * @author Asatryan on 26.04.2022
 */
interface CurrencyUi {

    fun <T> map(mapper: Mapper<T>): T

    interface Mapper<T> {

        fun map(id: String, text: String, isFavorite: Boolean): T

        class Ui(
            private val textView: TextView,
            private val compoundButton: CompoundButton
        ) : Mapper<Unit> {

            override fun map(id: String, text: String, isFavorite: Boolean) {
                textView.text = text
                compoundButton.isChecked = isFavorite
            }
        }

        class ChangeFavorite(
            private val changeFavorite: com.github.johnnysc.coremvvm.currencies.presentation.ChangeFavorite
        ) : Mapper<Unit> {

            override fun map(id: String, text: String, isFavorite: Boolean) =
                changeFavorite.changeFavorite(id)
        }

        class TheSame(private val currencyUi: CurrencyUi) : Mapper<Boolean> {
            override fun map(
                id: String,
                text: String,
                isFavorite: Boolean
            ): Boolean = currencyUi.map(Id(id))

            private class Id(private val id: String) : Mapper<Boolean> {

                override fun map(
                    id: String,
                    text: String,
                    isFavorite: Boolean
                ): Boolean = this.id == id
            }
        }

        class TheSameContent(private val currencyUi: CurrencyUi) : Mapper<Boolean> {
            override fun map(
                id: String,
                text: String,
                isFavorite: Boolean
            ): Boolean = currencyUi.map(Content(id, text, isFavorite))

            private class Content(
                private val id: String,
                private val text: String,
                private val isFavorite: Boolean
            ) : Mapper<Boolean> {

                override fun map(id: String, text: String, isFavorite: Boolean): Boolean =
                    this.id == id && this.text == text && this.isFavorite == isFavorite
            }
        }
    }

    class Base(
        private val id: String,
        private val text: String,
        private val isFavorite: Boolean
    ) : CurrencyUi {

        override fun <T> map(mapper: Mapper<T>): T = mapper.map(id, text, isFavorite)
    }
}
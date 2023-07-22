package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ItemUiType

interface CurrencyItemUiType {

    interface Base : ItemUiType.Base<CurrencyItemUi>

    interface Clickable : ItemUiType.Clickable<CurrencyItemUi, CurrenciesClickListener>
}
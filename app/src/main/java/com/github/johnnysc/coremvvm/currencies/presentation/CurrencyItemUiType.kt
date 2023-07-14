package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUiType

interface CurrencyItemUiType {

    interface Base : ItemUiType.Base<ItemUi>

    interface Clickable : ItemUiType.Clickable<ItemUi, CurrenciesClickListener>
}
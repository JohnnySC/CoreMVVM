package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ItemUiType
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

interface CurrencyItemUiType {

    interface Base : ItemUiType.Base<MyView, CurrencyItemUi>

    interface Clickable : ItemUiType.Clickable<MyView, CurrencyItemUi, CurrenciesClickListener>
}
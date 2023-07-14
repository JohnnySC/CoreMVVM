package com.github.johnnysc.coremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUiType

interface CurrencyItemUiType : ItemUiType.Base<ItemUi>

interface CurrencyItemUiTypeClickable : ItemUiType.Clickable<ItemUi, CurrenciesClickListener>
package com.github.johnnysc.coremvvm.presentation.adapter

import android.view.View
import androidx.annotation.DrawableRes

/**
 * @author Asatryan on 01.06.2022
 */
interface MyView {

    fun show(text: CharSequence) = Unit

    fun show(textId: Int) = Unit

    fun loadImage(url: String) = Unit

    fun showImageResource(@DrawableRes id: Int) = Unit

    fun enable(enabled: Boolean) = Unit

    fun check(checked: Boolean) = Unit

    fun handleClick(listener: View.OnClickListener) = Unit
}
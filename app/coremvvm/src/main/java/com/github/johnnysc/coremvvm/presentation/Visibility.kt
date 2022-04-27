package com.github.johnnysc.coremvvm.presentation

import android.view.View

/**
 * @author Asatryan on 26.04.2022
 */
interface Visibility {

    fun apply(view: View)

    abstract class Abstract(private val visibility: Int) : Visibility {
        override fun apply(view: View) = view.setVisibility(visibility)
    }

    class Visible : Abstract(View.VISIBLE)
    class Gone : Abstract(View.GONE)
    class InVisible : Abstract(View.INVISIBLE)
}
package com.github.johnnysc.coremvvm.core

import android.content.Context
import androidx.annotation.StringRes

/**
 * @author Asatryan on 24.04.2022
 */
interface ManageResources {

    fun string(@StringRes id: Int): String

    class Base(private val context: Context) : ManageResources {
        override fun string(id: Int) = context.getString(id)
    }
}
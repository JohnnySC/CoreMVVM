package com.github.johnnysc.coremvvm.core

/**
 * @author Asatryan on 24.04.2022
 */
interface Matches<T> {

    fun matches(data: T): Boolean
}
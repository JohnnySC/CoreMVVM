package com.github.johnnysc.coremvvm.core

/**
 * @author Asatryan on 26.04.2022
 */
interface Save<T> {

    fun save(data: T)
}
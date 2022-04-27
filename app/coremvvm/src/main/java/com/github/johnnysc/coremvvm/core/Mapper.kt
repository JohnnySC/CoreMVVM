package com.github.johnnysc.coremvvm.core

/**
 * @author Asatryan on 24.04.2022
 */
interface Mapper<S, R> {

    fun map(data: S): R

    interface Unit<T> : Mapper<T, kotlin.Unit>
}
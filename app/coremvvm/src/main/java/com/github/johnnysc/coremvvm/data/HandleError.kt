package com.github.johnnysc.coremvvm.data

/**
 * @author Asatryan on 24.04.2022
 */
interface HandleError {

    fun handle(error: Exception): Exception
}
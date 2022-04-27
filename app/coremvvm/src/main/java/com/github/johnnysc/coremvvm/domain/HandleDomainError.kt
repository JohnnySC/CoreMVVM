package com.github.johnnysc.coremvvm.domain

import com.github.johnnysc.coremvvm.data.HandleError
import java.net.UnknownHostException

/**
 * @author Asatryan on 24.04.2022
 */
class HandleDomainError : HandleError {

    override fun handle(error: Exception) =
        if (error is UnknownHostException)
            NoInternetConnectionException()
        else
            ServiceUnavailableException()
}
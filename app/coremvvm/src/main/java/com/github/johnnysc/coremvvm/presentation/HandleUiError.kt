package com.github.johnnysc.coremvvm.presentation

import androidx.annotation.StringRes
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.core.ManageResources
import com.github.johnnysc.coremvvm.data.HandleError
import com.github.johnnysc.coremvvm.data.ProvideRetrofitBuilder
import com.github.johnnysc.coremvvm.domain.NoInternetConnectionException
import com.github.johnnysc.coremvvm.domain.ServiceUnavailableException

/**
 * @author Asatryan on 24.04.2022
 */
abstract class HandleUiErrorAbstract(
    private val manageResources: ManageResources,
    private val globalErrorCommunication: GlobalErrorCommunication.Update,
    private val handleError: HandleError =
        HandleGenericUiError(manageResources, globalErrorCommunication)
) : HandleError {

    @StringRes
    protected open val noConnectionExceptionMessage: Int = R.string.no_connection_message

    @StringRes
    protected open val serviceUnavailableExceptionMessage: Int = R.string.no_service_message

    override fun handle(error: Exception): Exception {
        val messageId = when (error) {
            is NoInternetConnectionException -> noConnectionExceptionMessage
            is ServiceUnavailableException -> serviceUnavailableExceptionMessage
            else -> 0
        }
        return if (messageId == 0)
            handleError.handle(error)
        else {
            globalErrorCommunication.map(manageResources.string(messageId))
            error
        }
    }
}

class HandleGenericUiError(
    private val manageResources: ManageResources,
    private val globalErrorCommunication: GlobalErrorCommunication.Update
) : HandleError {

    override fun handle(error: Exception): Exception {
        globalErrorCommunication.map(manageResources.string(R.string.unexpected_error_message))
        return error
    }
}

class HandleUiError(
    manageResources: ManageResources,
    globalErrorCommunication: GlobalErrorCommunication.Update
) : HandleUiErrorAbstract(manageResources, globalErrorCommunication)
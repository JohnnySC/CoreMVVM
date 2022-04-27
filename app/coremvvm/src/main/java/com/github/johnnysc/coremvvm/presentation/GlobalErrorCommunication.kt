package com.github.johnnysc.coremvvm.presentation

/**
 * @author Asatryan on 24.04.2022
 */
interface GlobalErrorCommunication {

    interface Observe : Communication.Observe<String>

    interface Update : Communication.Update<String>

    interface Mutable : Communication.Mutable<String>, Observe, Update

    class Base : Communication.SinglePostUpdate<String>(), Mutable
}
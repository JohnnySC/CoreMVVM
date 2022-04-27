package com.github.johnnysc.coremvvm.presentation

/**
 * @author Asatryan on 26.04.2022
 */
interface ProgressCommunication {

    interface Update : Communication.Update<Visibility>

    interface Observe : Communication.Observe<Visibility>

    interface Mutable : Update, Observe

    class Base : Communication.UiUpdate<Visibility>(), Mutable
}
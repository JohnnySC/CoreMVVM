package com.github.johnnysc.coremvvm.presentation
/**
 * @author Asatryan on 24.04.2022
 */
interface NavigationCommunication {

    interface Update : Communication.Update<NavigationScreen>

    interface Observe : Communication.Observe<NavigationScreen>

    interface Mutable : Update, Observe

    class Base : Communication.SinglePostUpdate<NavigationScreen>(), Mutable
}
package com.github.johnnysc.coremvvm.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.github.johnnysc.coremvvm.core.Mapper

/**
 * @author Asatryan on 24.04.2022
 */
interface Communication {

    interface Observe<T> {
        fun observe(owner: LifecycleOwner, observer: Observer<T>)
    }

    interface Update<T> : Mapper.Unit<T>

    interface Mutable<T> : Observe<T>, Update<T>

    abstract class Abstract<T : Any>(
        protected val mutableLiveData: MutableLiveData<T>
    ) : Mutable<T> {

        override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
            mutableLiveData.observe(owner, observer)
        }
    }

    abstract class UiUpdate<T : Any>(
        liveData: MutableLiveData<T> = MutableLiveData()
    ) : Abstract<T>(liveData) {

        override fun map(data: T) {
            mutableLiveData.value = data
        }
    }

    abstract class PostUpdate<T : Any>(
        liveData: MutableLiveData<T> = MutableLiveData()
    ) : Abstract<T>(liveData) {

        override fun map(data: T) = mutableLiveData.postValue(data)
    }

    abstract class SingleUiUpdate<T : Any> : UiUpdate<T>(SingleLiveEvent())

    abstract class SinglePostUpdate<T : Any> : PostUpdate<T>(SingleLiveEvent())

    class Empty<T> : Mutable<T> {
        override fun map(data: T) = Unit

        override fun observe(owner: LifecycleOwner, observer: Observer<T>) = Unit
    }
}
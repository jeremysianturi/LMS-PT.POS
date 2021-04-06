package com.pos.lms.mobile.helper

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

/**
 * Created by Muhammad Zaim Milzam on 06/04/21.
 * linkedin : Muhammad Zaim Milzam
 */

class LiveData {

//    fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
//        liveData.observe(this, Observer { it?.let { t -> action(t) } })
//    }

    fun <T> LifecycleOwner.observe(liveData: MutableLiveData<T>, action: (t: T) -> Unit) {
        liveData.observe(this, { it?.let { t -> action(t) } })
    }

//    fun <T> LifecycleOwner.observe(liveData: SingleLiveEvent<T>, action: (t: T) -> Unit) {
//        liveData.observe(this, Observer { it?.let { t -> action(t) } })
//    }
}
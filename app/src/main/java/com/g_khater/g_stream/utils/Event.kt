package com.g_khater.g_stream.utils

class Event<T> {
    private val observers = mutableSetOf<(T) -> Unit>()

    val size : Int get() = observers.size

    operator fun plusAssign(observer: (T) -> Unit) {
        observers.add(observer)
    }

    operator fun minusAssign(observer: (T) -> Unit) {
        observers.remove(observer)
    }

    operator fun invoke(value: T) {
        for (observer in observers)
            observer(value)
    }
}
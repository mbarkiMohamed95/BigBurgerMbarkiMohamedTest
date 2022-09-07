package com.example.bigburgermbarkimohamedtest.helpers.states


sealed class DataState<out R> {
    data class Success<out T>(val data: T, val finished: Boolean = false) : DataState<T>()
    data class Error(val exception: Exception, val cancelled: Boolean = false) : DataState<Nothing>()
    object Idle : DataState<Nothing>()
}

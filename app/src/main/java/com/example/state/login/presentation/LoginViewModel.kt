package com.example.state.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private var _number = MutableLiveData<Int>(0)
    val number : LiveData<Int> = _number

    fun onChangedNumber() {
        _number.value = _number.value!! + 1
    }
}
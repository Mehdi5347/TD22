package com.example.td2.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.td2.domain.usecase.CreateUserUseCase
import com.example.td2.domain.entity.User
import com.example.td2.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val counter: MutableLiveData<Int> = MutableLiveData()

    init{
       counter.value = 0

    }

    fun onClickedIncrement(emailUser: String) {
        viewModelScope.launch() {
            createUserUseCase.invoke(User("test"))
            delay(timeMillis = 1000)
            val user = getUserUseCase.invoke("test")
            val debug = "debug"
        }
    }
}
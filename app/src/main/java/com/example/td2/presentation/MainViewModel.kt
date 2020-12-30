package com.example.td2.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.td2.domain.usecase.CreateUserUseCase
import com.example.td2.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser)
            val loginStatus = if (user != null) {
                LoginSuccess(user.email)
            } else {
                LoginError
            }
            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }
    }
}
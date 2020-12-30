package com.example.td2.presentation

sealed class LoginStatus

data class LoginSuccess(val email: String) : LoginStatus()

object LoginError : LoginStatus()
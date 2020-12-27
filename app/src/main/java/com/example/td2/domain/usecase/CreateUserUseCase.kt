package com.example.td2.domain.usecase

import com.example.td2.data.repository.UserRepository
import com.example.td2.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
    ) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)


    }
}
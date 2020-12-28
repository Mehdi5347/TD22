package com.example.td2.domain.usecase

import com.example.td2.data.repository.UserRepository
import com.example.td2.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User? {
        return userRepository.getUser(email)
    }
}
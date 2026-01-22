package com.victor_rb.petat.dto

data class ChangePasswordRequestDTO (
    val oldPassword: String,
    val newPassword: String
)
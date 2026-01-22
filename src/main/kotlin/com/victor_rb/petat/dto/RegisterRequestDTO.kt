package com.victor_rb.petat.dto

import com.victor_rb.petat.entity.Pet
import com.victor_rb.petat.utils.enums.DocumentTypeEnum
import jakarta.validation.constraints.NotBlank

data class RegisterRequestDTO (
    val name: String,
    val lastName: String,
    @NotBlank val email: String,
    val documentType: DocumentTypeEnum,
    @NotBlank val documentNumber: String,
    val contact: String,
    val pet: List<Pet>
)
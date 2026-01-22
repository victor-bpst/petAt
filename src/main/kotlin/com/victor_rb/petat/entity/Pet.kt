package com.victor_rb.petat.entity

import com.victor_rb.petat.utils.enums.PetTypeEnum

class Pet(
    val name: String,
    val type: PetTypeEnum,
    val breed: String,
    val description: String
) {
}
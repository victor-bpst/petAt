package com.victor_rb.petat.entity

import com.victor_rb.petat.utils.enums.DocumentTypeEnum
import com.victor_rb.petat.utils.enums.MailValidationStatus
import org.apache.commons.lang3.RandomStringUtils
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "pet_owners")
class Owner (
    @Id
    val id: ObjectId = ObjectId(),
    val name: String,
    val lastName: String,
    @Indexed(unique = true) val email: String,
    val documentType: DocumentTypeEnum,
    @Indexed(unique = true) val documentNumber: String,
    val contact: String,
    val encryptedPassword: String = "not_activate",
    val registrationStatus: MailValidationStatus = MailValidationStatus.NOT_ACTIVATED,
    val verificationToken: String = RandomStringUtils.randomAlphanumeric(12),
    val pet: List<Pet> = emptyList()
)
package com.victor_rb.petat.service

import com.victor_rb.petat.dto.LoginRequestDTO
import com.victor_rb.petat.dto.RegisterRequestDTO
import com.victor_rb.petat.entity.Owner
import com.victor_rb.petat.exceptions.DocumentNumberExistsException
import com.victor_rb.petat.exceptions.EmailExistsException
import com.victor_rb.petat.mapper.OwnerMapper
import com.victor_rb.petat.repository.OwnerRepository
import com.victor_rb.petat.security.JwtUtil
import com.victor_rb.petat.utils.communication.EmailVerification
import com.victor_rb.petat.utils.enums.MailValidationStatus
import com.victor_rb.petat.utils.enums.RolesEnum
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class OwnerService (
    private val repository: OwnerRepository,
    private val emailVerification: EmailVerification,
    private val jwtUtil: JwtUtil,
    private val ownerMapper: OwnerMapper
){

    fun register(data: RegisterRequestDTO): Owner {


        val owner = ownerMapper.toEntity(data)

        if (repository.existsByEmail(owner.email)){
            throw EmailExistsException()
        }

        if (repository.existsByDocumentNumber(owner.documentNumber)){
            throw DocumentNumberExistsException()
        }

        emailVerification.sendVerificationMail(
            owner.email,
            owner.verificationToken
        )

        return repository.save(owner)
    }

    fun login(data: LoginRequestDTO): String {

        val owner = repository.findByEmail(data.email)

        var token = ""

        if (owner.registrationStatus == MailValidationStatus.NOT_ACTIVATED
            && owner.verificationToken == data.rawPassword
        ){
            token = jwtUtil.generateToken(data.email, RolesEnum.TEMPORARY)

        }else if (owner.registrationStatus == MailValidationStatus.ACTIVATED){
            val encryptedPassword = BCryptPasswordEncoder().encode(data.rawPassword)

            if (encryptedPassword.equals(owner.encryptedPassword)){
                token = jwtUtil.generateToken(data.email, RolesEnum.PET_OWNER)
            }
        }

        return token
    }

    fun sendResetEmail(email: String): String {

        val newToken = RandomStringUtils.randomAlphanumeric(12)

        repository.updateTokenByEmail(email, newToken)

        emailVerification.sendVerificationMail(
            email,
            newToken
        )

        return ("Email com a senha temporaria enviada para ${email}.")

    }
}
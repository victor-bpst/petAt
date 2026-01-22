package com.victor_rb.petat.controller

import com.victor_rb.petat.dto.LoginRequestDTO
import com.victor_rb.petat.dto.RegisterRequestDTO
import com.victor_rb.petat.entity.Owner
import com.victor_rb.petat.service.OwnerService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class OwnerController (private val ownerService: OwnerService) {

    @PostMapping(
        "/register",
        consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun registerNewOwner(@RequestBody request: RegisterRequestDTO ): ResponseEntity<Owner> {

        val newOwner = ownerService.register(request)

        return ResponseEntity.ok(newOwner)
    }

    @PostMapping(
        "/login",
        consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun login(@RequestBody requestDTO: LoginRequestDTO): ResponseEntity<String> {

        val token = ownerService.login(requestDTO)

        return ResponseEntity.ok(token)
    }

    @PostMapping(
        "/passwordRecovery",
        consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun passwordRecovery(@RequestBody request: Map<String, String>): ResponseEntity<String> {

        val email = request["email"]?.trim() ?: throw IllegalArgumentException("Necessario email válido")

        return ResponseEntity.ok(ownerService.sendResetEmail(email))

    }

}
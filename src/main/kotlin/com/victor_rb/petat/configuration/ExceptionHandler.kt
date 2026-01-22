package com.victor_rb.petat.configuration

import com.victor_rb.petat.exceptions.DocumentNumberExistsException
import com.victor_rb.petat.exceptions.EmailExistsException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(EmailExistsException::class)
    fun handleEmailExists(ex: EmailExistsException) = ResponseEntity
        . badRequest()
        .body(ex.message)

    @ExceptionHandler(DocumentNumberExistsException::class)
    fun handlerDocumentNumberExists(ex: DocumentNumberExistsException) = ResponseEntity
        .badRequest()
        .body(ex.message)

}
package com.victor_rb.petat.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class OwnerNotFoundException: RuntimeException("Usuario Não Encontrado")
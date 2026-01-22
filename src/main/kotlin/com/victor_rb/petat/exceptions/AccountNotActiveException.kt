package com.victor_rb.petat.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.CONFLICT)
class AccountNotActiveException : RuntimeException("Sua conta ainda não esta ativa, verifique seu email de ativação ou use o botão Recuperar Senha")
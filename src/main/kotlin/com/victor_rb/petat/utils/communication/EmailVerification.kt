package com.victor_rb.petat.utils.communication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailVerification {

    @Autowired
    private lateinit var mailSender: JavaMailSender

    fun sendVerificationMail(mail: String, initPassword: String){
        val message = SimpleMailMessage().apply {
            setTo(mail)
            subject = "Confirmação de Email"
            text = "Use a senha em seu proximo login, sera necessario troca-la : ${initPassword}"
        }

        mailSender.send(message)
    }
}
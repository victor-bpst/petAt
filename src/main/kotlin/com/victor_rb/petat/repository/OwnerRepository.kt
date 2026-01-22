package com.victor_rb.petat.repository

import com.victor_rb.petat.entity.Owner
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.Update

interface OwnerRepository: MongoRepository<Owner, String> {

    fun existsByEmail(email: String): Boolean

    fun existsByDocumentNumber(number: String): Boolean

    fun findByEmail(email: String): Owner

    @Query("{ 'email': ?0 }")
    @Update("{ '\$set': { 'verificationToken': ?1 } }")
    fun updateTokenByEmail(email: String, verificationToken: String)

}
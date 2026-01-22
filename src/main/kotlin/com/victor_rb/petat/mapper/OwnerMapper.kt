package com.victor_rb.petat.mapper

import com.victor_rb.petat.dto.RegisterRequestDTO
import com.victor_rb.petat.entity.Owner
import org.bson.types.ObjectId
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ObjectFactory
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface OwnerMapper {

    @ObjectFactory
    fun createOwner(dto: RegisterRequestDTO): Owner {
        return Owner(
            id = ObjectId(),
            name = dto.name,
            lastName = dto.lastName,
            email = dto.email,
            documentType = dto.documentType,
            documentNumber = dto.documentNumber,
            contact = dto.contact,
            pet = dto.pet
        )
    }

    @Mapping(target = "id", ignore = true)
    fun toEntity(dto: RegisterRequestDTO): Owner
}
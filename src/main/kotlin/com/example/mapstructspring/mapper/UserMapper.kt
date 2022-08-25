package com.example.mapstructspring.mapper

import com.example.mapstructspring.dto.UserDto
import com.example.mapstructspring.models.Department
import com.example.mapstructspring.models.AppUser
import com.example.mapstructspring.repository.DepartmentRepository
import org.mapstruct.*
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.EntityNotFoundException

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class UserMapper {
    @Autowired private lateinit var departmentRepository: DepartmentRepository

    @Mappings(
        Mapping(source = "departmentId", target = "department", qualifiedByName = ["getDepartment"]),
    )
    abstract fun fromUserDtoToUser(userDto: UserDto): AppUser

    @Named("getDepartment")
    fun getDepartment(departmentId: String): Department {
        return this.departmentRepository.findById(departmentId).orElseThrow {
            throw EntityNotFoundException("Unable to find department with id $departmentId")
        }
    }
}
package com.example.mapstructspring.repository

import com.example.mapstructspring.models.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DepartmentRepository: JpaRepository<Department, String> {}
package com.example.mapstructspring.models

import javax.persistence.*

@Entity
@Table
data class Department (
    @Id
    @Column
    val departmentId: String,

    @Column
    val departmentName: String
)

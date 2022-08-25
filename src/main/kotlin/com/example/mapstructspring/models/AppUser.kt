package com.example.mapstructspring.models

import javax.persistence.*

@Entity
@Table
data class AppUser (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long? = null,

    @Column(unique = true)
    val username: String,

    @ManyToOne
    val department: Department,
)

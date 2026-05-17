package com.voodz.hanbook.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "football_clubs", schema = "football")
class FootballClub (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    var id: Long? = null,

    @Column(name = "club_name", unique = true, nullable = false)
    var name: String = "",

    @Column(name = "creation_date")
    var creationDate: LocalDate? = null,

    @Column(name = "stadium_name")
    var stadiumName: String? = null,

    @Column(name = "uefa_rating", precision = 8, scale = 3)
    var uefaRating: BigDecimal? = null,
)
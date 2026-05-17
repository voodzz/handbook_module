package com.voodz.hanbook.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "football_players", schema = "football")
class FootballPlayer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    var id: Long? = null,

    @Column(name = "first_name", nullable = false)
    var firstName: String = "",

    @Column(name = "last_name", nullable = false)
    var lastName: String = "",

    @Column(name = "birth_date")
    var birthDate: LocalDate? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_name", referencedColumnName = "club_name")
    var club: FootballClub? = null,

    @Column(precision = 3, scale = 2)
    var height: BigDecimal? = null,

    @Column(name = "market_value")
    var marketValue: Long? = null,

    @Column
    var notes: String? = null
)
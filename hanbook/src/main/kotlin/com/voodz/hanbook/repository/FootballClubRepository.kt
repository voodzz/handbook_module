package com.voodz.hanbook.repository

import com.voodz.hanbook.model.FootballClub
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FootballClubRepository : JpaRepository<FootballClub, Long>
package com.voodz.hanbook.repository

import com.voodz.hanbook.model.FootballPlayer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FootballPlayerRepository : JpaRepository<FootballPlayer, Long>
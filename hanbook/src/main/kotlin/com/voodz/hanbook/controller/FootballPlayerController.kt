package com.voodz.hanbook.controller

import com.voodz.hanbook.model.FootballPlayer
import com.voodz.hanbook.repository.FootballClubRepository
import com.voodz.hanbook.repository.FootballPlayerRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/players")
class FootballPlayerController(
    private val playerRepository: FootballPlayerRepository,
    private val clubRepository: FootballClubRepository,
) {
    @GetMapping
    fun listPlayers(
        @RequestParam(defaultValue = "lastName") sortBy: String,
        model: Model,
    ): String {
        model.addAttribute("players", playerRepository.findAll(Sort.by(sortBy)))
        model.addAttribute("studentInfo", "Войтукевич Р.Ю., 3 курс, 2 группа, 2026")
        return "players/list"
    }

    @GetMapping("/add")
    fun showAddForm(model: Model): String {
        model.addAttribute("player", FootballPlayer()) // Пустой объект для формы
        model.addAttribute("clubs", clubRepository.findAll()) // Список для выпадающего меню
        return "players/form"
    }

    @PostMapping("/save")
    fun savePlayer(@ModelAttribute("player") player: FootballPlayer): String {
        playerRepository.save(player)
        return "redirect:/players"
    }

    @GetMapping("/delete/{id}")
    fun deletePlayer(@PathVariable id: Long): String {
        playerRepository.deleteById(id)
        return "redirect:/players"
    }

    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable id: Long, model: Model): String {
        val player = playerRepository.findById(id).orElseThrow { IllegalArgumentException("Invalid player Id:$id") }
        model.addAttribute("player", player)
        model.addAttribute("clubs", clubRepository.findAll())
        return "players/form"
    }
}
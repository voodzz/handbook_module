package com.voodz.hanbook.controller

import com.voodz.hanbook.model.FootballClub
import com.voodz.hanbook.repository.FootballClubRepository
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
@RequestMapping("/clubs")
class FootballClubController(private val clubRepository: FootballClubRepository) {
    @GetMapping
    fun listClubs(@RequestParam(defaultValue = "name") sortBy: String, model: Model): String {
        model.addAttribute("clubs", clubRepository.findAll(Sort.by(sortBy)))
        model.addAttribute("studentInfo", "Войтукевич Р.Ю., 3 курс, 2 группа, 2026")
        return "clubs/list"
    }

    @GetMapping("/add")
    fun showAddForm(model: Model): String {
        model.addAttribute("club", FootballClub())
        return "clubs/form"
    }

    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable id: Long, model: Model): String {
        val club = clubRepository.findById(id).orElseThrow { IllegalArgumentException("Invalid club Id:$id") }
        model.addAttribute("club", club)
        return "clubs/form"
    }

    @PostMapping("/save")
    fun saveClub(@ModelAttribute club: FootballClub): String {
        clubRepository.save(club)
        return "redirect:/clubs"
    }

    @GetMapping("/delete/{id}")
    fun deleteClub(@PathVariable id: Long): String {
        clubRepository.deleteById(id)
        return "redirect:/clubs"
    }
}
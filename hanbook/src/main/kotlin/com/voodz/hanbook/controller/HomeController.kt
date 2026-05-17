package com.voodz.hanbook.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class HomeController {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("studentInfo", "Войтукевич Р.Ю., 3 курс, 2 группа, 2026")
        return "index"
    }
}
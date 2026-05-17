package com.voodz.hanbook.configuration

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, model: Model): String {
        model.addAttribute("errorMessage", ex.message ?: "Произошла непредвиденная ошибка")
        model.addAttribute("studentInfo", "Войтукевич Р.Ю., 3 курс, 2 группа, 2026")
        return "error"
    }
}
package br.com.`fsj-backmix`.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("teste")
class Teste() {


    @GetMapping("teste")
    fun terra() : String {
        return "A"
    }
}
package br.com.`fsj-backmix`

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@ServletComponentScan
class FsjbackmixApplication

fun main(args: Array<String>) {
    runApplication<FsjbackmixApplication>(*args)
}
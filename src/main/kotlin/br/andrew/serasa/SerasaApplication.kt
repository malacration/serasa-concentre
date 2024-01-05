package br.andrew.serasa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SerasaApplication

fun main(args: Array<String>) {
	runApplication<SerasaApplication>(*args)
}

package br.andrew.serasa.controllers

import br.andrew.serasa.model.Consulta
import br.andrew.serasa.repositorys.ConsultaRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("")
class IndexController(
    val repository : ConsultaRepository) {

    @GetMapping("{cpfCnpj}")
    fun getCpfCnpj(@PathVariable cpfCnpj : String): List<Consulta> {
        return repository.findByCpfCnpj(cpfCnpj)
    }
}
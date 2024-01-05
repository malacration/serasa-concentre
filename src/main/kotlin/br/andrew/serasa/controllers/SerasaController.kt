package br.andrew.serasa.controllers

import br.andrew.serasa.model.Consulta
import br.andrew.serasa.repositorys.ConsultaRepository
import br.andrew.serasa.services.SerasaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("serasa")
class SerasaController(
    val repository : ConsultaRepository,
    val service : SerasaService) {

    @GetMapping("{cpfCnpj}")
    fun get(@PathVariable cpfCnpj : String, score : Boolean = false): Any? {
        //TODO decidir se consulta N vezes?
        val parse = service.getByCpf(cpfCnpj,score)
        return repository.save(Consulta(parse))
    }

    @GetMapping("{cpfCnpj}/score")
    fun getScore(@PathVariable cpfCnpj : String): Any? {
        return get(cpfCnpj,true)
    }

    @GetMapping("{cpfCnpj}/score/blocos")
    fun getScoreBlocos(@PathVariable cpfCnpj : String): Any? {
        return service.getByCpf(cpfCnpj,true)
    }
}
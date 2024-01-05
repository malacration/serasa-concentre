package br.andrew.serasa.services

import br.andrew.serasa.model.magnetivo.B49C
import br.andrew.serasa.model.retorno.ParseRetorno
import br.andrew.serasa.config.SerasaProperties
import br.andrew.serasa.model.magnetivo.CpfCnpj
import org.springframework.http.RequestEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class SerasaService(val conf: SerasaProperties,
                    val restTemplate: RestTemplate) {

    fun getByCpf(cpf : String, score : Boolean = false) : ParseRetorno {
        val b4 = B49C(CpfCnpj(cpf),score).toString()
        val url = conf.getBase()
        val request = RequestEntity
            .post(url+b4)
            .build()
        val retorno  = restTemplate.exchange(request, String::class.java).body ?: throw Exception("Erro ao consultar Serasa")
        return ParseRetorno(retorno,CpfCnpj(cpf))
    }
}
package br.andrew.serasa.repositorys

import br.andrew.serasa.model.Consulta
import org.springframework.data.repository.CrudRepository

interface ConsultaRepository : CrudRepository<Consulta, Int?> {


    fun findByCpfCnpj(cpfCnpj : String) : List<Consulta>

}
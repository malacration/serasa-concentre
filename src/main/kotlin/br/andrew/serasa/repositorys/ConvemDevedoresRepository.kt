package br.andrew.serasa.repositorys

import br.andrew.serasa.model.ConvemDevedores
import org.springframework.data.repository.CrudRepository

interface ConvemDevedoresRepository : CrudRepository<ConvemDevedores, Int?> {

}
package br.andrew.serasa.repositorys

import br.andrew.serasa.model.FalenciaConcordata
import org.springframework.data.repository.CrudRepository

interface FalenciaConcordataRepository : CrudRepository<FalenciaConcordata, Int?> {

}
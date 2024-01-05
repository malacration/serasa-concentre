package br.andrew.serasa.repositorys

import br.andrew.serasa.model.AcaoJudicial
import org.springframework.data.repository.CrudRepository

interface AcaoJudicialRepository : CrudRepository<AcaoJudicial, Int?> {

}
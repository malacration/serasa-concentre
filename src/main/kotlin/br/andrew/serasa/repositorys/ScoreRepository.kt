package br.andrew.serasa.repositorys

import br.andrew.serasa.model.ScoreRshi
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ScoreRepository : CrudRepository<ScoreRshi, Int?> {

}
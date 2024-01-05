package br.andrew.serasa.repositorys

import br.andrew.serasa.model.Protestos
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProtestosRepository : CrudRepository<Protestos, Int?> {

}
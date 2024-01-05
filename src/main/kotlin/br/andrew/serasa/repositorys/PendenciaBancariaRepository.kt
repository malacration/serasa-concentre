package br.andrew.serasa.repositorys

import br.andrew.serasa.model.PendenciaBancaria
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PendenciaBancariaRepository : CrudRepository<PendenciaBancaria, Int?> {

}
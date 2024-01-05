package br.andrew.serasa.repositorys

import br.andrew.serasa.model.PendenciaComercial
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PendenciaComercialRepository : CrudRepository<PendenciaComercial, Int?> {

}
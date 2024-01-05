package br.andrew.serasa.repositorys

import br.andrew.serasa.model.ChequeSemFundo
import org.springframework.data.repository.CrudRepository

interface ChequeSemFundoRepository : CrudRepository<ChequeSemFundo, Int?> {

}
package br.andrew.serasa.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "ACAO_JUDICIAL")
class AcaoJudicial(
    val dataInicial: Date,
    val dataFinal: Date,
    val valor: Double,
    val origem: String,
    val total: Double,
    @ManyToOne
    @JsonBackReference
    val consulta: Consulta) {

    @Id
    @GeneratedValue
    var id : Int? = null
}
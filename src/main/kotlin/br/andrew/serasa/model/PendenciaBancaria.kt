package br.andrew.serasa.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "PENDENCIA_BANCARIA")
class PendenciaBancaria(
    val subTipo: String,
    val dataInicial: Date,
    val dataFinal: Date,
    val total: Double,
    val valor: Double,
    val tipoOcorrencia: String,
    val origem: String,
    @ManyToOne
    @JsonBackReference
    val consulta: Consulta
) {

    @Id
    @GeneratedValue
    var id : Int? = null
}
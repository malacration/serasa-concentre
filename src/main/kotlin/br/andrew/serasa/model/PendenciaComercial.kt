package br.andrew.serasa.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "PENDENCIA_COMERCIAL")
class PendenciaComercial(
    val dataInicial: Date,
    val dataFinal: Date,
    val quantidade: Int,
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
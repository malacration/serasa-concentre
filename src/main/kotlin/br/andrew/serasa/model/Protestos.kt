package br.andrew.serasa.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "PROTESTOS")
class Protestos(
    val subTipo: String,
    val dataInicial: Date,
    val dataFinal: Date,
    val total: Double,
    val valor: Double,
    val origem: String,
    @ManyToOne
    @JsonBackReference
    val consulta: Consulta
) {

    @Id
    @GeneratedValue
    var id : Int? = null
}
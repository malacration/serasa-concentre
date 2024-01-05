package br.andrew.serasa.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.util.Date


@Entity
@Table(name = "CHEQUE_SEM_FUNDO")
class ChequeSemFundo(
    val dataInicial: Date,
    val dataFinal: Date,
    val qtdTotal: String,
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
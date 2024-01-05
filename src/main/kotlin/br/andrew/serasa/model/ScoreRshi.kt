package br.andrew.serasa.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.util.Date


@Entity
@Table(name = "SCORE")
class ScoreRshi(
    val data: Date,
    val fator: String,
    @Column(name = "PROBABILIDADE_INADIMPLENCIA")
    val probabilidadeInadimplencia: String,
    val mensagem: String,
    val porte: String,
    val subTipo: String,
    @ManyToOne
    @JsonBackReference
    val consulta: Consulta
) {

    @Id
    @GeneratedValue
    var id : Int? = null

}
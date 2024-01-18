package br.andrew.serasa.model.retorno

import br.andrew.serasa.model.Consulta
import br.andrew.serasa.model.ScoreRshi
import java.text.SimpleDateFormat
import java.util.Date


class ScorePessoaJuridicaRetorno(val entrada : String) {

    private val parse = RetornoSerasa()
    val data : String = entrada.substring(11, 11+8)
    val hora : String = entrada.substring(19, 19+8)
    val fator : String = entrada.substring(27, 27+4)
    val probabilidadeInadimplencia : String = entrada.substring(31, 31+5)
    val mensagem : String = entrada.substring(36, 36+78)
    val porte : String = entrada.substring(114, 115)

    val subTipo = entrada.substring(8, 8+3)

    val dataTime : Date = SimpleDateFormat("ddMMyyy HH:mm:ss").parse("$data $hora")

    init {
        if(subTipo != "001")
            throw Exception("Subtipo invalido $subTipo")
    }

    fun getScore(consulta : Consulta): ScoreRshi {
        return ScoreRshi(dataTime,fator,probabilidadeInadimplencia,mensagem,porte,subTipo,consulta)
    }

}
package br.andrew.serasa.model

import br.andrew.serasa.model.magnetivo.Parametro
import br.andrew.serasa.model.retorno.RetornoSerasa
import java.util.Date


class ScorePessoaFisicaRetorno(val entrada : String) {

    private val parse = RetornoSerasa()
    val pontuacao : String = entrada.substring(10, 10+4)
    val range : String = entrada.substring(14, 14+6)
    val probabilidadeInadimplencia : String = Parametro("",
        entrada.substring(20, 20+5).replace(",","").trim()
        ,4,'0',true).toString()
    val mensagem : String = entrada.substring(25, 25+49)

    val subTipo = entrada.substring(8, 8+3)

    fun getScore(consulta : Consulta): ScoreRshi {
        return ScoreRshi(Date(),pontuacao,probabilidadeInadimplencia,mensagem,range,subTipo,consulta)
    }
}
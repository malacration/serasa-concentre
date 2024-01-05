package br.andrew.serasa.model.retorno

import br.andrew.serasa.model.AcaoJudicial
import br.andrew.serasa.model.Consulta
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.Date


class AcaoJudicialRetorno(val entrada : String) : RetornoSerasa() {

    val subTipo : String = entrada.substring(4, 6)
    val dataInicial : Date = getDate(entrada.substring(6, 6+8))
    val dataFinal : Date = getDate(entrada.substring(14, 14+8))
    val valor : Double =  getDouble(entrada.substring(31, 31+15))
    val origem : String = entrada.substring(46, 46+30)
    val quantidade: Int = entrada.substring(22, 22+9).toInt()

    init {
        if(subTipo != "00")
            throw Exception("Subtipo nao implementado para Pendencia Financeira")
    }


    @JsonIgnore
    fun getAcaoJudicial(consulta: Consulta): AcaoJudicial {
        return AcaoJudicial(dataInicial,dataFinal,valor,origem,quantidade,consulta)
    }
}
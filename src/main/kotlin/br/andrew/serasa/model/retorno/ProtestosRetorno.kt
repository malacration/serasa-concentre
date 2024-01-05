package br.andrew.serasa.model.retorno

import br.andrew.serasa.model.Consulta
import br.andrew.serasa.model.Protestos
import java.util.*

class ProtestosRetorno(val entrada : String) : RetornoSerasa(){

    val subTipo : String = entrada.substring(4, 6)
    val dataInicial : Date = getDate(entrada.substring(6, 6+8))
    val dataFinal : Date = getDate(entrada.substring(14, 14+8))
    val total : Double = entrada.substring(24, 33).toDouble()
    val valor : Double = getDouble(entrada.substring(33, 46))
    val origem : String = entrada.substring(46, 76)

    init {
        if(subTipo != "00")
            throw Exception("Subtipo nao implementado para Protestos")
    }

    fun getProtesto(consulta : Consulta) : Protestos{
        return Protestos(subTipo,dataInicial,dataFinal,total,valor,origem,consulta)
    }

}
package br.andrew.serasa.model.retorno

import br.andrew.serasa.model.Consulta
import br.andrew.serasa.model.ConvemDevedores
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.Date


class ConvemDevedoresRetorno(val entrada : String) : RetornoSerasa(){

    val subTipo : String = entrada.substring(4, 6)
    val dataInicial : Date = getDate(entrada.substring(6, 6+8))
    val dataFinal : Date = getDate(entrada.substring(14, 14+8))
    val quantidade : Int = entrada.substring(22, 22+9).toInt()
    val valor : Double = getDouble(entrada.substring(31, 31+15))
    val origem : String = entrada.substring(46, 46+16)

    init {
        if(subTipo != "00")
            throw Exception("Subtipo nao implementado para Convem Devedores")
    }


    @JsonIgnore
    fun getConvemDevedores(consulta : Consulta): ConvemDevedores {
        return ConvemDevedores(dataInicial,dataFinal,quantidade,valor,origem,consulta)
    }

}
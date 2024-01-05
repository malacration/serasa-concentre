package br.andrew.serasa.model.retorno

import br.andrew.serasa.model.Consulta
import br.andrew.serasa.model.PendenciaComercial
import java.util.Date


class PendenciaComercialRetorno(val entrada : String) : RetornoSerasa(){

    val subTipo : String = entrada.substring(4, 6)
    val dataInicial : Date = getDate(entrada.substring(6, 6+8))
    val dataFinal : Date = getDate(entrada.substring(14, 14+8))
    val qtdTotal : Int = entrada.substring(22, 31).toInt()
    val valor : Double = getDouble(entrada.substring(31, 46))
    val tipoOcorencia : String = entrada.substring(46, 47)
    val origem : String = entrada.substring(47, 46+17)

    init {
        if(subTipo != "00")
            throw Exception("Subtipo nao implementado para Pendencia Financeira")
    }


    fun getPendenciaComercial(consulta : Consulta): PendenciaComercial {
        return PendenciaComercial(dataInicial,dataFinal,qtdTotal,valor,tipoOcorencia,origem,consulta)
    }

}
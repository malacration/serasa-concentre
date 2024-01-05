package br.andrew.serasa.model.retorno

import br.andrew.serasa.model.ChequeSemFundo
import br.andrew.serasa.model.Consulta
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.Date


class ChequeSemFundoRetorno(val entrada : String) : RetornoSerasa(){

    val subTipo : String = entrada.substring(4, 6)
    val dataInicial : Date = getDate(entrada.substring(6, 6+8))
    val dataFinal : Date = getDate(entrada.substring(14, 14+8))
    val qtdTotal : String = entrada.substring(22, 31)
    val valor : Double = getDouble(entrada.substring(31, 46))
    val origem : String = entrada.substring(46, 46+16)

    init {
        if(subTipo != "00")
            throw Exception("Subtipo nao implementado para Pendencia Financeira")
    }

    @JsonIgnore
    fun getChequeSemFundo(consulta: Consulta): ChequeSemFundo {
        return ChequeSemFundo(dataInicial,dataFinal,qtdTotal,valor,origem,consulta)

    }

}
package br.andrew.serasa

import br.andrew.serasa.model.retorno.ConvemDevedoresRetorno
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat
import java.util.*

class ConvemDevedoresTest {

    @Test
    fun test(){
        val entrada = "I230002022030520230228000000017000000006165936EFAIDROF DNPTT W000000093900360                                      "
        val acaoJudicial = ConvemDevedoresRetorno(entrada)
        Assertions.assertEquals(getDate("20220305"), acaoJudicial.dataInicial)
        Assertions.assertEquals(getDate("20230228"), acaoJudicial.dataFinal)
        Assertions.assertEquals(17, acaoJudicial.quantidade)
        Assertions.assertEquals(getDouble("000000006165936"), acaoJudicial.valor)
        Assertions.assertEquals("EFAIDROF DNPTT W", acaoJudicial.origem)
    }

    protected fun getDate(date : String) : Date {
        return SimpleDateFormat("yyyyMMdd").parse(date)
    }

    protected fun getDouble(value : String) : Double {
        return value.toDouble().div(100)
    }

}
package br.andrew.serasa

import br.andrew.serasa.model.retorno.AcaoJudicialRetorno
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat

class AcaoJudicialTest {

    @Test
    fun test(){
        val entrada = "I120002019011020190110000000001000000019204599SANTOS                        000000019204599                        "
        val acaoJudicial = AcaoJudicialRetorno(entrada)
        Assertions.assertEquals(SimpleDateFormat("yyyyMMdd").parse("20190110"), acaoJudicial.dataInicial)
        Assertions.assertEquals(SimpleDateFormat("yyyyMMdd").parse("20190110"), acaoJudicial.dataFinal)
        Assertions.assertEquals(1, acaoJudicial.quantidade)
        Assertions.assertEquals(192045.99, acaoJudicial.valor)
        Assertions.assertEquals("SANTOS                        ", acaoJudicial.origem)
    }

}
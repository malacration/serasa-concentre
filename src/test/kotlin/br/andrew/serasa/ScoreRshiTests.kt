package br.andrew.serasa

import br.andrew.serasa.model.retorno.RetornoSerasa
import br.andrew.serasa.model.retorno.ScoreRshiRetorno
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ScoreRshiTests {

    @Test
    fun test(){
        val parser = RetornoSerasa()
        val entrada = "F900RSHI0011412202317:06:15055000117PROBABILIDADE DE INADIMPLENCIA:  1,17%                                         "
        val score = ScoreRshiRetorno(entrada)
        Assertions.assertEquals("0550", score.fator)
        Assertions.assertEquals(" ", score.porte)
        Assertions.assertEquals("14122023", score.data)
        Assertions.assertEquals("17:06:15", score.hora)
        Assertions.assertEquals("Thu Dec 14 17:06:15 AMT 2023", score.dataTime.toString())
        Assertions.assertEquals("PROBABILIDADE DE INADIMPLENCIA:  1,17%                                        ", score.mensagem)
        Assertions.assertEquals("00117", score.probabilidadeInadimplencia)
    }


    @Test
    fun semCalculo(){
        val entrada = "F900RSHI0091412202317:08:41SCORE NAO CALCULADO - INSUFICIENCIA INFORMACOES BASE DE DADOS SERASA EXPERIAN           "
        Assertions.assertThrows(Exception::class.java) {
            ScoreRshiRetorno(entrada)
        }
    }
}

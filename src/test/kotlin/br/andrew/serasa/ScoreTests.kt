package br.andrew.serasa

import br.andrew.serasa.model.ScorePessoaFisicaRetorno
import br.andrew.serasa.model.retorno.RetornoSerasa
import br.andrew.serasa.model.retorno.ScorePessoaJuridicaRetorno
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ScoreTests {

    @Test
    fun test(){
        val parser = RetornoSerasa()
        val entrada = "F900RSHI0011412202317:06:15055000117PROBABILIDADE DE INADIMPLENCIA:  1,17%                                         "
        val score = ScorePessoaJuridicaRetorno(entrada)
        Assertions.assertEquals("0550", score.fator)
        Assertions.assertEquals(" ", score.porte)
        Assertions.assertEquals("14122023", score.data)
        Assertions.assertEquals("17:06:15", score.hora)
        Assertions.assertEquals("Thu Dec 14 17:06:15 AMT 2023", score.dataTime.toString())
        Assertions.assertEquals("PROBABILIDADE DE INADIMPLENCIA:  1,17%                                        ", score.mensagem)
        Assertions.assertEquals("00117", score.probabilidadeInadimplencia)
    }


    @Test
    fun scorePessoaFisica(){
        val entrada = "F900RSHM000961A     3,70 ESPACO RESERVADO PARA MENSAGEM DA INSTITUICAO                                         HRLN"
        val score = ScorePessoaFisicaRetorno(entrada)
        Assertions.assertEquals("0961", score.pontuacao)
        Assertions.assertEquals("A     ", score.range)
        Assertions.assertEquals("ESPACO RESERVADO PARA MENSAGEM DA INSTITUICAO    ", score.mensagem)
        Assertions.assertEquals(49, score.mensagem.length)
        Assertions.assertEquals("0370", score.probabilidadeInadimplencia)
        Assertions.assertEquals(4, score.probabilidadeInadimplencia.length)
    }


    @Test
    fun semCalculo(){
        val entrada = "F900RSHI0091412202317:08:41SCORE NAO CALCULADO - INSUFICIENCIA INFORMACOES BASE DE DADOS SERASA EXPERIAN           "
        Assertions.assertThrows(Exception::class.java) {
            ScorePessoaJuridicaRetorno(entrada)
        }
    }
}

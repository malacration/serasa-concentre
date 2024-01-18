package br.andrew.serasa.model.retorno

import br.andrew.serasa.model.ScorePessoaFisicaRetorno
import br.andrew.serasa.model.magnetivo.CpfCnpj
import com.fasterxml.jackson.annotation.JsonIgnore

class ParseRetorno(@JsonIgnore val retorno : String, val cpfCnpj : CpfCnpj) {

    val blocos = mutableListOf<String>()

    var blocsTypes : List<String>? = null

    init {
        val tamanho = retorno.length-400
        val numBlocos = tamanho/115

        for(i in 0..numBlocos-1){
            blocos.add(retorno.substring(400+(i*115), 400+((i+1)*115)))
        }
        blocsTypes = blocos.groupBy { it.substring(0,4) }.map { it.key }.toList().filter {
            it != "I110"
            && it != "I220"
            && it != "P002"
            && it != "I001"
            && it != "I140"
            && it != "I160"
            && it != "I170"
            && it != "I130"
            && it != "I120"
            && it != "A900"
            && it != "I230"
            && it != "I150"
        }
    }


    fun getNadaConsta() : List<String> {
        return blocos.filter { it.startsWith("A90000") }.map { it.substring(42,43+70) }
    }

    fun getProtestos() : List<ProtestosRetorno> {
        return blocos.filter { it.startsWith("I11000") }.map { ProtestosRetorno(it) }
    }

    fun getPendenciaComercial(): List<PendenciaComercialRetorno> {
        return blocos.filter { it.startsWith("I22000") }.map { PendenciaComercialRetorno(it) }
    }

    fun getPendenciaBancaria(): List<PendenciaBancariaRetorno> {
        return blocos.filter { it.startsWith("I14000") }.map { PendenciaBancariaRetorno(it) }
    }

    fun getChequeSemFundo(): List<ChequeSemFundoRetorno> {
        //TODO - Implementar testes - 160 e 170

        return blocos.filter { it.startsWith("I16000") }.map { ChequeSemFundoRetorno(it) }
            .toMutableList().also { it.addAll(
                blocos.filter { it.startsWith("I17000") }.map { ChequeSemFundoRetorno(it) }.toList()
            )}
    }

    fun getAcaoJudicial(): List<AcaoJudicialRetorno> {
        return blocos.filter { it.startsWith("I12000") }.map { AcaoJudicialRetorno(it) }
    }

    fun getFalenciaConcordata(): List<FalenciaConcordataRetorno> {
        return blocos.filter { it.startsWith("I15000") }.map { FalenciaConcordataRetorno(it) }
    }

    fun getScorePessoaJuridicaRshi() : List<ScorePessoaJuridicaRetorno>{
        return blocos.filter { it.startsWith("F900RSHI00") }.map { ScorePessoaJuridicaRetorno(it) }
    }

    fun getScorePessoaFisica() : List<ScorePessoaFisicaRetorno> {
        return blocos.filter { it.startsWith("F900RSHM00") }.map { ScorePessoaFisicaRetorno(it) }
    }

    fun getConvemDevedores() : List<ConvemDevedoresRetorno>{
        return blocos.filter { it.startsWith("I23000") }.map { ConvemDevedoresRetorno(it) }
    }

}
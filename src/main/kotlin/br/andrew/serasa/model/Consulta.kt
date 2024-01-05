package br.andrew.serasa.model

import br.andrew.serasa.model.magnetivo.CpfCnpj
import br.andrew.serasa.model.retorno.ParseRetorno
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "CONSULTA")
class Consulta(
    @JsonIgnore
    val entrada : String,
    val cpfCnpj : String,
    val dataConsulta : Date = Date()
) {

    val tipoPessoa : TipoPessoa = CpfCnpj(cpfCnpj).tipoPessoa()

    @OneToMany(mappedBy="consulta", cascade = [ CascadeType.ALL])
    var acaoJudicial: List<AcaoJudicial> = listOf()

    @OneToMany(mappedBy="consulta", cascade = [ CascadeType.ALL])
    var chequeSemFundo: List<ChequeSemFundo> = listOf()

    @OneToMany(mappedBy="consulta", cascade = [ CascadeType.ALL])
    var convemDevedores: List<ConvemDevedores> = listOf()

    @OneToMany(mappedBy="consulta", cascade = [ CascadeType.ALL])
    var falenciaConcordata: List<FalenciaConcordata> = listOf()

    @OneToMany(mappedBy="consulta", cascade = [ CascadeType.ALL])
    var pendenciaBancaria: List<PendenciaBancaria> = listOf()

    @OneToMany(mappedBy="consulta", cascade = [ CascadeType.ALL])
    var pendenciaComercial: List<PendenciaComercial> = listOf()

    @OneToMany(mappedBy="consulta", cascade = [ CascadeType.ALL])
    var protestos: List<Protestos> = listOf()

    @OneToMany(mappedBy="consulta", cascade = [ CascadeType.ALL])
    var score: List<ScoreRshi> = listOf()

    constructor(parseRetorno: ParseRetorno) : this(
        parseRetorno.retorno,
        parseRetorno.cpfCnpj.value,
    ){
        acaoJudicial = parseRetorno.getAcaoJudicial().map { it.getAcaoJudicial(this) }
        chequeSemFundo = parseRetorno.getChequeSemFundo().map { it.getChequeSemFundo(this) }
        convemDevedores = parseRetorno.getConvemDevedores().map { it.getConvemDevedores(this) }
        falenciaConcordata = parseRetorno.getFalenciaConcordata().map { it.getFalenciaConcordata(this) }
        pendenciaBancaria = parseRetorno.getPendenciaBancaria().map { it.getPendenciaBancaria(this) }
        pendenciaComercial = parseRetorno.getPendenciaComercial().map { it.getPendenciaComercial(this) }
        protestos = parseRetorno.getProtestos().map { it.getProtesto(this) }
        score = parseRetorno.getScoreRshi().map { it.getScore(this) }
    }

    @Id
    @GeneratedValue
    var id : Int? = null
}
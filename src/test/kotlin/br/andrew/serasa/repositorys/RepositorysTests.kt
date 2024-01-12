package br.andrew.serasa.repositorys

import br.andrew.serasa.SerasaApplication
import br.andrew.serasa.model.Consulta
import br.andrew.serasa.model.magnetivo.B49C
import br.andrew.serasa.model.magnetivo.CpfCnpj
import br.andrew.serasa.model.magnetivo.I001
import br.andrew.serasa.model.magnetivo.P002
import br.andrew.serasa.model.retorno.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest(classes = [SerasaApplication::class])
class RepositorysTests {

    @Autowired
    lateinit var acaoRepository : AcaoJudicialRepository
    @Autowired
    lateinit var pendenciaComercialRepository : PendenciaComercialRepository
    @Autowired
    lateinit var consultaRepository: ConsultaRepository
    @Autowired
    lateinit var chequeRepositry: ChequeSemFundoRepository
    @Autowired
    lateinit var convemDevedoresRepository: ConvemDevedoresRepository
    @Autowired
    lateinit var falenciaConcordataRepository: FalenciaConcordataRepository
    @Autowired
    lateinit var pendenciaBancariaRepository: PendenciaBancariaRepository
    @Autowired
    lateinit var protestosRepository: ProtestosRepository
    @Autowired
    lateinit var scoreRepository: ScoreRepository
    val parse = RetornoSerasa()

    @Test
    fun test(){
        val experado = "B49C      082639170000185JC     FI                   S99SINIAN                               N                                                                                                                                                                                                                                                                                                                  P002RSPU                                                                                                           I00100R                                                                                                            T999"
        val b49c = B49C(CpfCnpj("82639170000185"), false)
        Assertions.assertEquals(experado, b49c.toString())
    }

    @Test
    fun p200(){
        val experado = "P002RSPU                                                                                                           "
        Assertions.assertEquals(experado.length, 115)
        val p200 = P002("P002","","")
        Assertions.assertEquals(115, p200.resultado.length)
        Assertions.assertEquals(experado, p200.resultado)
    }

    @Test
    fun i001Test(){
        val experado = "I00100R                                                                                                            "
        Assertions.assertEquals(experado.length, 115)
        val resultado = I001("I001","00").resultado
        Assertions.assertEquals(115, resultado.length)
        Assertions.assertEquals(experado, resultado)
    }

    val retorno = "B49C      082639170000185JC     FI0000200            S99SFIMAN                            SS N                                                                         000000000               00  2023120816491400540054    0055                                                                        0000                    3#                                                                             P002RSPU                                                                                                           I00100R                                                                                                            I130002021060420210604000000001000000000000000BLUMENAU                                                             I150002021041320210413000000000000000000000001SAO PAULO                                                            I160002020123020201230000000000000000000000018BANCO BRADESCO  000000000000000                                      I220002019052020200831000000028000000008908579VOPUNAAN CIYHTFST000000020513548                                     I140002021010120210101000000001000000000300000TESTE BANCO     000000000300000                                      I120002020032320210908000000003000000065006919BLUMENAU                      000000065481442                        I110002019043020210823000000130000000000870746BLUMENAU                      000000125533140                        I230002020030720200727000000027000000000037500FKYZY WLZXKI VDH000000006095355                                      I1300120210604FR0003BNU SCBLUMENAU                      000000202106071731510000837114FALENCIA REQUERIDA           I1500120210413FDGER0001063734453AUTO POSTO POTENCIA LTDA                          000000201102031545170000001668   I15002FALENCIA DECRETADA                                                                                           I17001202012302371109000000018BNU SCBANCO BRADESCO      BLUMENAU                        00000020210115050727       I170020132085970                                                                                                   I2200120200831DP 000000008908579                                    S0000000105113801         B0101662281V         I2200200000020210815000000VDUPLICATA                                                                               I2200375552133000170OPUNAAN CIYHTFST                                                                      VP       I2200120200719OO 000000000059402                                    S0000999988706181         A0916594893V         I2200200000020201030000000VOUTRAS OPER                                                                             I2200302558157000162VWDNHXOKCC NTHQW                                                                      VP       I2200120200410NF 000000000134983                                    S52281                    B0078546768V         I2200200000020210712000000VNOTA FISCAL                                                                             I2200300904606000151UXONUJI WXSHDCFU                                                                      VP       I2200120200309NF 000000000073553                                    S51775                    B0078655976V         I2200200000020210712000000VNOTA FISCAL                                                                             I2200300904606000151UXONUJI WXSHDCFU                                                                      VP       I2200120200212NF 000000000109926                                    S51277                    B0077748716V         I2200200000020210712000000VNOTA FISCAL                                                                             I2200300904606000151UXONUJI WXSHDCFU                                                                      VP       I1400120210101AG 005359081000134000000000300000      TESTE BANCO                                       SA0035250108I14002 00000020221101092117673263          EMPRESTIMO                                                              I120012021090800050001JF 000000065006919BNU SCBLUMENAU                      S 000000202109141955090029771709       I12002FISCAL FEDERAL                                                                                               I120012021012200030001EX 000000000000000BNU SCBLUMENAU                      S 000000202102011038180028263495       I12002EXECUCAO                                                                                                     I120012020032300050001EX 000000000474523BNU SCBLUMENAU                      S 000000202004031436320026650124       I12002EXECUCAO                                                                                                     I11001202108230001   000000000870746BNU SCBLUMENAU                               000000202109172210590323745818    I11001202108230001   000000000220649BNU SCBLUMENAU                               000000202109172210590323745817    I11001202107240002   000000000220649BNU SCBLUMENAU                               000000202108190329070322222754    I11001202107240001   000000000870746BNU SCBLUMENAU                               000000202108171908470322091472    I11001202106240001   000000000220649BNU SCBLUMENAU                               000000202107161302250320427270    I2300120200727DM 000000000037500BNU SCFKYZY WLZXKI VDH              00000046094     0288776930882411601A           I23002DUPLICATA DE VENDA MERCANTIL                                                                                 I2300120200725DM 000000000222552BNU SCHPEY DIGMI XC LV              1486            0030676690873829637A           I23002DUPLICATA DE VENDA MERCANTIL                                                                                 I2300120200720DM 000000000117600BNU SCFKYZY WLZXKI VDH              00000045101     0288776930882411599A           I23002DUPLICATA DE VENDA MERCANTIL                                                                                 I2300120200625DM 000000000250945BNU SCHPEY DIGMI XC LV              1458            0030676690858876127A           I23002DUPLICATA DE VENDA MERCANTIL                                                                                 I2300120200621DM 000000000103491BNU SCHPEY DIGMI XC LV              1436            0030676690857689985A           I23002DUPLICATA DE VENDA MERCANTIL                                                                                 T999000PROCESSO ENCERRADO NORMALMENTE                                                                             "

    @Test
    fun testeNumRegistro(){
        val tamanho = retorno.length-400
        println(tamanho)

        val numBlocos = tamanho/115

        Assertions.assertEquals(54,numBlocos)
        val blocos = mutableListOf<String>()
        for(i in 0..numBlocos-1){
            blocos.add(retorno.substring(400+(i*115), 400+((i+1)*115)))
        }
        val numRegistro = retorno.substring(399, retorno.length)
        val blocosKey = blocos.map { it.substring(0,4) }.groupBy { it }
        println(numRegistro)
    }


    @Test
    fun blocos(){
        val parse = ParseRetorno(retorno,CpfCnpj("088.086.650-03"))
        Assertions.assertEquals(54,parse.blocos.size)
    }

    @Test
    fun getProtesto(){
        val parse = ParseRetorno(retorno,CpfCnpj("088.086.650-03"))
        val protestos = parse.getProtestos()
        Assertions.assertEquals(1,protestos.size)
        Assertions.assertEquals(this.parse.getDate("20190430"),protestos.get(0).dataInicial)
        Assertions.assertEquals(this.parse.getDate("20210823"),protestos.get(0).dataFinal)
        Assertions.assertEquals(13000.0,protestos.get(0).total)
        Assertions.assertEquals(this.parse.getDouble("870746"),protestos.get(0).valor)
        Assertions.assertTrue(protestos.get(0).origem.startsWith("BLUMENAU"))

        val consulta : Consulta = consultaRepository.save(Consulta(parse))
        protestosRepository.saveAll(protestos.map { it.getProtesto(consulta) })

    }


    @Test
    fun pendenciaComercialTest(){
        val parse = ParseRetorno(retorno,CpfCnpj("088.086.650-03"))

        val pendencias = parse.getPendenciaComercial()
        Assertions.assertEquals(1,pendencias.size)
        Assertions.assertEquals("I220002019052020200831000000028000000008908579VOPUNAAN CIYHTFST000000020513548                                     ",
            pendencias.get(0).entrada)
        Assertions.assertEquals(this.parse.getDate("20190520" ),pendencias.get(0).dataInicial)
        Assertions.assertEquals(this.parse.getDate("20200831"),pendencias.get(0).dataFinal)
        Assertions.assertEquals(28,pendencias.get(0).qtdTotal)
        Assertions.assertEquals(this.parse.getDouble("000000008908579"),pendencias.get(0).valor)
        Assertions.assertEquals("V",pendencias.get(0).tipoOcorencia)
        Assertions.assertEquals("OPUNAAN CIYHTFST",pendencias.get(0).origem)

        val consulta : Consulta = consultaRepository.save(Consulta(parse))
        pendenciaComercialRepository.saveAll(pendencias.map { it.getPendenciaComercial(consulta) })
    }

    @Test
    fun acaoJudicial(){
        val entrada = "I120002019011020190110000000001000000019204599SANTOS                        000000019204599                        "
        val consulta : Consulta = consultaRepository.save(Consulta(ParseRetorno(retorno,CpfCnpj("088.086.650-03"))))
        var id : Int? = null
        consulta.acaoJudicial.forEach {
            id = it.id
                    Assertions.assertNotNull(it.id)
        }
        Assertions.assertTrue(acaoRepository.findById(id!!).isPresent)
    }


    @Test
    fun pendenciaBancaria(){
        val parse = ParseRetorno(retorno,CpfCnpj("088.086.650-03"))
        val pendencias = parse.getPendenciaBancaria()
        Assertions.assertEquals(1,pendencias.size)
        Assertions.assertEquals("I140002021010120210101000000001000000000300000TESTE BANCO     000000000300000                                      ",
            pendencias.get(0).entrada)
        Assertions.assertEquals(this.parse.getDate("20210101"),pendencias.get(0).dataInicial)
        Assertions.assertEquals(this.parse.getDate("20210101"),pendencias.get(0).dataFinal)
        Assertions.assertEquals("T",pendencias.get(0).tipoOcorencia)
        Assertions.assertEquals("TESTE BANCO     ",pendencias.get(0).origem)
        Assertions.assertEquals(16,pendencias.get(0).origem.length)

        val consulta : Consulta = consultaRepository.save(Consulta(parse))
        pendenciaBancariaRepository.saveAll(pendencias.map { it.getPendenciaBancaria(consulta) })
    }

    @Test
    fun chequeSemFundo(){
        val parse = ParseRetorno(retorno,CpfCnpj("088.086.650-03"))
        val pendencias = parse.getChequeSemFundo()
        Assertions.assertEquals(1,pendencias.size)
        Assertions.assertEquals("I160002020123020201230000000000000000000000018BANCO BRADESCO  000000000000000                                      ",
            pendencias.get(0).entrada)
        Assertions.assertEquals(this.parse.getDate("20201230"),pendencias.get(0).dataInicial)
        Assertions.assertEquals(this.parse.getDate("20201230"),pendencias.get(0).dataFinal)
        Assertions.assertEquals("000000000",pendencias.get(0).qtdTotal)
        Assertions.assertEquals(this.parse.getDouble("000000000000018"),pendencias.get(0).valor)
        Assertions.assertEquals("BANCO BRADESCO  ",pendencias.get(0).origem)
        Assertions.assertEquals(16,pendencias.get(0).origem.length)

        val consulta : Consulta = consultaRepository.save(Consulta(parse))
        chequeRepositry.saveAll(pendencias.map { it.getChequeSemFundo(consulta) })
    }


    @Test
    fun falenciaConcordata(){
        val parse = ParseRetorno(retorno,CpfCnpj("088.086.650-03"))
        val pendencias = parse.getFalenciaConcordata()
        Assertions.assertEquals(1,pendencias.size)
        Assertions.assertEquals(this.parse.getDate("20210413"),pendencias.get(0).dataInicial)
        Assertions.assertEquals(this.parse.getDate("20210413"),pendencias.get(0).dataFinal)
        Assertions.assertEquals(0.0,pendencias.get(0).total)
        Assertions.assertEquals(this.parse.getDouble("000000000000001"),pendencias.get(0).valor)
        Assertions.assertEquals(30,pendencias.get(0).origem.length)
        val consulta : Consulta = consultaRepository.save(Consulta(parse))
        falenciaConcordataRepository.saveAll(pendencias.map { it.getFalenciaConcordata(consulta) })
    }


    @Test
    fun convemTest(){
        val entrada = "I230002022030520230228000000017000000006165936EFAIDROF DNPTT W000000093900360                                      "
        val convem = ConvemDevedoresRetorno(entrada)

        val consulta : Consulta = consultaRepository.save(Consulta(ParseRetorno(retorno,CpfCnpj("088.086.650-03"))))
        convemDevedoresRepository.save(convem.getConvemDevedores(consulta))
    }

    @Test
    fun scoreTest(){
        val entrada = "F900RSHI0011412202317:06:15055000117PROBABILIDADE DE INADIMPLENCIA:  1,17%                                         "
        val score = ScoreRshiRetorno(entrada)
        val consulta : Consulta = consultaRepository.save(Consulta(ParseRetorno(retorno,CpfCnpj("088.086.650-03"))))
        scoreRepository.save(score.getScore(consulta))
    }
}
package castelles.com.github.structuresmodule

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class NubankChallengeTest {

    private lateinit var challenge: NubankChallenge

    @Before
    fun setUp() {
        challenge = NubankChallenge()
    }

    @Test
    fun asdafasc() {
        val array: Array<Int> = Array(8) {
            0
        }

        array.set(0, 6)
        array.set(1, 18)
        array.set(2, 8)
        array.set(3, 14)
        array.set(4, 10)
        array.set(5, 12)
        array.set(6, 18)
        array.set(7, 9)
        assertEquals(challenge.formacaoDeTime(array, 3, 7), 50)
    }

    @Test
    fun primeirosPontos_somenteOPrimeiroItem() {
        val array: Array<Int> = Array(8) { 0 }
        array.set(0, 6)
        array.set(1, 18)
        array.set(2, 8)
        array.set(3, 14)
        array.set(4, 10)
        array.set(5, 12)
        array.set(6, 18)
        array.set(7, 9)

        assertEquals(challenge.primeirosPontos(array, 1)[0], 6)
    }

    @Test
    fun primeirosPontos_metadeDosItens() {
        val array: Array<Int> = Array(8) { 0 }
        array.set(0, 6)
        array.set(1, 18)
        array.set(2, 8)
        array.set(3, 14)
        array.set(4, 10)
        array.set(5, 12)
        array.set(6, 18)
        array.set(7, 9)

        assertEquals(challenge.primeirosPontos(array, 4)[0], 6)
        assertEquals(challenge.primeirosPontos(array, 4)[1], 18)
        assertEquals(challenge.primeirosPontos(array, 4)[2], 8)
        assertEquals(challenge.primeirosPontos(array, 4)[3], 14)
    }

    @Test
    fun primeirosPontos_maisDaMetadeDosItens() {
        val array: Array<Int> = Array(8) { 0 }
        array.set(0, 6)
        array.set(1, 18)
        array.set(2, 8)
        array.set(3, 14)
        array.set(4, 10)
        array.set(5, 12)
        array.set(6, 18)
        array.set(7, 9)

        assertEquals(challenge.primeirosPontos(array, 6)[0], 6)
        assertEquals(challenge.primeirosPontos(array, 6)[1], 18)
        assertEquals(challenge.primeirosPontos(array, 6)[4], 10)
        assertEquals(challenge.primeirosPontos(array, 6)[5], 12)
    }

    @Test
    fun primeirosPontos_todosOsItens() {
        val array: Array<Int> = Array(8) { 0 }
        array.set(0, 6)
        array.set(1, 18)
        array.set(2, 8)
        array.set(3, 14)
        array.set(4, 10)
        array.set(5, 12)
        array.set(6, 18)
        array.set(7, 9)

        assertEquals(challenge.primeirosPontos(array, 8)[0], 6)
        assertEquals(challenge.primeirosPontos(array, 8)[1], 18)
        assertEquals(challenge.primeirosPontos(array, 8)[6], 18)
        assertEquals(challenge.primeirosPontos(array, 8)[7], 9)
    }

    @Test
    fun ultimosPontos_somenteOUltimoItem() {
        val array: Array<Int> = Array(8) { 0 }
        array.set(0, 6)
        array.set(1, 18)
        array.set(2, 8)
        array.set(3, 14)
        array.set(4, 10)
        array.set(5, 12)
        array.set(6, 18)
        array.set(7, 9)

        assertEquals(challenge.ultimosPontos(array, 1)[0], 9)
    }

    @Test
    fun ultimosPontos_metadeDosItens() {
        val array: Array<Int> = Array(8) { 0 }
        array.set(0, 6)
        array.set(1, 18)
        array.set(2, 8)
        array.set(3, 14)
        array.set(4, 10)
        array.set(5, 12)
        array.set(6, 18)
        array.set(7, 9)

        assertEquals(challenge.ultimosPontos(array, 4)[0], 10)
        assertEquals(challenge.ultimosPontos(array, 4)[1], 12)
        assertEquals(challenge.ultimosPontos(array, 4)[2], 18)
        assertEquals(challenge.ultimosPontos(array, 4)[3], 9)
    }

    @Test
    fun ultimosPontos_maisDaMetadeDosItens() {
        val array: Array<Int> = Array(8) { 0 }
        array.set(0, 6)
        array.set(1, 18)
        array.set(2, 8)
        array.set(3, 14)
        array.set(4, 10)
        array.set(5, 12)
        array.set(6, 18)
        array.set(7, 9)

        assertEquals(challenge.ultimosPontos(array, 6)[0], 8)
        assertEquals(challenge.ultimosPontos(array, 6)[1], 14)
        assertEquals(challenge.ultimosPontos(array, 6)[4], 18)
        assertEquals(challenge.ultimosPontos(array, 6)[5], 9)
    }

    @Test
    fun ultimosPontos_todosOsItens() {
        val array: Array<Int> = Array(8) { 0 }
        array.set(0, 6)
        array.set(1, 18)
        array.set(2, 8)
        array.set(3, 14)
        array.set(4, 10)
        array.set(5, 12)
        array.set(6, 18)
        array.set(7, 9)

        assertEquals(challenge.primeirosPontos(array, 8)[0], 6)
        assertEquals(challenge.primeirosPontos(array, 8)[1], 18)
        assertEquals(challenge.primeirosPontos(array, 8)[6], 18)
        assertEquals(challenge.primeirosPontos(array, 8)[7], 9)
    }

    @Test
    fun maiorPontuacao_unicoValor() {
        val array: Array<Int> = Array(1) { 0 }
        array.set(0, 6)

        assertEquals(challenge.maiorPontuacao(array), 6)
    }

    @Test
    fun maiorPontuacao_doisValores() {
        val array: Array<Int> = Array(2) { 0 }
        array.set(0, 6)
        array.set(1, 12)

        assertEquals(challenge.maiorPontuacao(array), 12)
    }

    @Test
    fun maiorPontuacao_valoresRepetidos() {
        val array: Array<Int> = Array(7) { 0 }
        array.set(0, 6)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 2)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 5)

        assertEquals(challenge.maiorPontuacao(array), 9)
    }

    @Test
    fun recebeIndice_maiorValorNoComeco() {
        val array: Array<Int> = Array(7) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 2)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 5)

        assertEquals(challenge.maiorPontuacao(array).pontuacao, 18)
        assertEquals(challenge.maiorPontuacao(array).indice, 0)
    }

    @Test
    fun recebeIndice_maiorValorNoMeio() {
        val array: Array<Int> = Array(7) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 22)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 5)

        assertEquals(challenge.maiorPontuacao(array).pontuacao, 22)
        assertEquals(challenge.maiorPontuacao(array).indice, 3)
    }

    @Test
    fun recebeIndice_maiorValorNoFinal() {
        val array: Array<Int> = Array(7) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 2)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 34)

        assertEquals(challenge.maiorPontuacao(array).pontuacao, 34)
        assertEquals(challenge.maiorPontuacao(array).indice, 6)
    }

    @Test
    fun removerUnico() {
        val array: Array<Int> = Array(1) { 0 }
        array.set(0, 18)

        val result = challenge.remover(array, 18).toMutableList()

        val expected: Array<Int> = Array(0) { 0 }
        val expectedToList = expected.toMutableList()

        assertTrue(expectedToList.containsAll(result))
    }

    @Test
    fun remover_noComeco() {
        val array: Array<Int> = Array(7) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 2)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 34)

        val result: Array<Int> = Array(6) { 0 }
        result.set(0, 7)
        result.set(1, 2)
        result.set(2, 2)
        result.set(3, 9)
        result.set(4, 9)
        result.set(5, 34)


        val arrayToList = challenge.remover(array, 18).toMutableList()
        val resultToList = result.toMutableList()
        assertTrue(resultToList.containsAll(arrayToList))
    }

    @Test
    fun remover_noMeio() {
        val array: Array<Int> = Array(7) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 45)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 34)

        val result: Array<Int> = Array(6) { 0 }
        result.set(0, 18)
        result.set(1, 7)
        result.set(2, 2)
        result.set(3, 9)
        result.set(4, 9)
        result.set(5, 34)


        val arrayToList = challenge.remover(array, 45).toMutableList()
        val resultToList = result.toMutableList()
        assertTrue(resultToList.containsAll(arrayToList))
    }

    @Test
    fun remover_noFinal() {
        val array: Array<Int> = Array(7) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 45)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 62)

        val result: Array<Int> = Array(6) { 0 }
        result.set(0, 18)
        result.set(1, 7)
        result.set(2, 2)
        result.set(3, 45)
        result.set(4, 9)
        result.set(5, 9)


        val arrayToList = challenge.remover(array, 62).toMutableList()
        val resultToList = result.toMutableList()
        assertTrue(resultToList.containsAll(arrayToList))
    }

    @Test
    fun remover_inexistente() {
        val array: Array<Int> = Array(7) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 45)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 62)

        val result: Array<Int> = Array(7) { 0 }
        result.set(0, 18)
        result.set(1, 7)
        result.set(2, 2)
        result.set(3, 45)
        result.set(4, 9)
        result.set(5, 9)
        result.set(6, 62)

        val arrayToList = challenge.remover(array, 44).toMutableList()
        val resultToList = result.toMutableList()
        assertTrue(resultToList.containsAll(arrayToList))
    }

    @Test
    fun resto_fatorPequeno() {
        val array: Array<Int> = Array(12) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 45)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 62)
        array.set(7, 432)
        array.set(8, 12)
        array.set(9, 78)
        array.set(10, 22)
        array.set(11, 34)

        val resultList: Array<Int> = Array(6) { 0 }
        resultList.set(0, 45)
        resultList.set(1, 9)
        resultList.set(2, 9)
        resultList.set(3, 62)
        resultList.set(4, 432)
        resultList.set(5, 12)

        val result = challenge.resto(array, 3).toMutableList()
        val resultToList = result.toMutableList()

        assertTrue(resultToList.containsAll(result))
    }

    @Test
    fun resto_fatorMetade() {
        val array: Array<Int> = Array(12) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 45)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 62)
        array.set(7, 432)
        array.set(8, 12)
        array.set(9, 78)
        array.set(10, 22)
        array.set(11, 34)

        val resultList: Array<Int> = Array(0) { 0 }
        val resultToList = resultList.toMutableList()

        val result = challenge.resto(array, 6).toMutableList()

        assertTrue(resultToList.containsAll(result))
    }

    @Test
    fun resto_fatorMaiorQueMetade() {
        val array: Array<Int> = Array(12) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 45)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 62)
        array.set(7, 432)
        array.set(8, 12)
        array.set(9, 78)
        array.set(10, 22)
        array.set(11, 34)

        val resultList: Array<Int> = Array(2) { 0 }
        resultList.set(0, 22)
        resultList.set(1, 34)
        val resultToList = resultList.toMutableList()

        val result = challenge.resto(array, 10).toMutableList()

        assertTrue(resultToList.containsAll(result))
    }

    @Test
    fun resto_fatorIgualAoTamanho() {
        val array: Array<Int> = Array(12) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 45)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 62)
        array.set(7, 432)
        array.set(8, 12)
        array.set(9, 78)
        array.set(10, 22)
        array.set(11, 34)

        val resultList: Array<Int> = Array(0) { 0 }
        val resultToList = resultList.toMutableList()

        val result = challenge.resto(array, 12).toMutableList()

        assertTrue(result.containsAll(resultToList))
    }

    @Test
    fun resto_fatorMaiorQueTamanho() {
        val array: Array<Int> = Array(12) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 45)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 62)
        array.set(7, 432)
        array.set(8, 12)
        array.set(9, 78)
        array.set(10, 22)
        array.set(11, 34)

        val resultList: Array<Int> = Array(0) { 0 }
        val resultToList = resultList.toMutableList()

        val result = challenge.resto(array, 14).toMutableList()

        assertTrue(result.containsAll(resultToList))
    }


    @Test
    fun addAll_removidoVazio() {
        val cabeca: Array<Int> = Array(0) { 0 }

        val corpo: Array<Int> = Array(2) { 0 }
        corpo.set(0, 18)
        corpo.set(1, 7)

        val cauda: Array<Int> = Array(2) { 0 }
        cauda.set(0, 3)
        cauda.set(1, 12)

        val expected: Array<Int> = Array(4) { 0 }
        expected.set(0, 18)
        expected.set(1, 7)
        expected.set(2, 3)
        expected.set(3, 12)
        val expectedToList = expected.toMutableList()

        val result = challenge.addAll(cabeca, corpo, cauda).toMutableList()

        assertTrue(expectedToList.containsAll(result))
        assertTrue(result.containsAll(expectedToList))
    }

    @Test
    fun cabecaECorpoVazio() {
        val cabeca: Array<Int> = Array(0) { 0 }

        val corpo: Array<Int> = Array(0) { 0 }

        val cauda: Array<Int> = Array(2) { 0 }
        cauda.set(0, 3)
        cauda.set(1, 12)

        val expected: Array<Int> = Array(2) { 0 }
        expected.set(0, 3)
        expected.set(1, 12)
        val expectedToList = expected.toMutableList()

        val result = challenge.addAll(cabeca, corpo, cauda).toMutableList()

        assertTrue(expectedToList.containsAll(result))
        assertTrue(result.containsAll(expectedToList))
    }

    @Test
    fun addAllEmpty() {
        val cabeca: Array<Int> = Array(0) { 0 }
        val cauda: Array<Int> = Array(0) { 0 }

        val result = challenge.addAll(cabeca, null, cauda)

        assertTrue(result.toMutableList().isEmpty())
    }

    @Test
    fun addAll_cabeca_cauda() {
        val cabeca: Array<Int> = Array(2) { 0 }
        cabeca.set(0, 3)
        cabeca.set(1, 45)
        val cauda: Array<Int> = Array(2) { 0 }
        cauda.set(0, 7)
        cauda.set(1, 13)

        val result = challenge.addAll(cabeca, null, cauda).toMutableList()

        val expected: Array<Int> = Array(4) { 0 }
        expected.set(0, 3)
        expected.set(1, 45)
        expected.set(2, 7)
        expected.set(3, 13)

        assertTrue(expected.toMutableList().containsAll(result))
        assertTrue(result.containsAll(expected.toMutableList()))
    }

    @Test
    fun main_timeIgualNumeroDePontuacoes() {
        val array: Array<Int> = Array(12) { 0 }
        array.set(0, 18)
        array.set(1, 7)
        array.set(2, 2)
        array.set(3, 45)
        array.set(4, 9)
        array.set(5, 9)
        array.set(6, 62)
        array.set(7, 432)
        array.set(8, 12)
        array.set(9, 78)
        array.set(10, 22)
        array.set(11, 34)

        assertEquals(challenge
            .formacaoDeTime(array, 6, 6), 673)
    }
}
package castelles.com.github.structuresmodule

import android.util.Log

class ArrayChallenge {

    data class Pontos(
        val pontuacao: Int,
        val indice: Int
    )

    fun primeirosPontos(pontuacao: Array<Int>, k: Int): Array<Int> {

        if (pontuacao.size <= k) {
            return pontuacao
        }

        val resultado: Array<Int> = Array(k) { 0 }

        for (i in 0 until k) {
            resultado[i] = pontuacao[i]
        }

        return resultado
    }

    fun ultimosPontos(pontuacao: Array<Int>, k: Int): Array<Int> {

        var size = pontuacao.size

        if (size <= k) {
            return pontuacao
        }

        val resultado: Array<Int> = Array(k) { 0 }
        var fatorDeInsercao = 0

        for (i in (size - k) until size) {
            resultado[fatorDeInsercao] = pontuacao[i]
            fatorDeInsercao++
        }

        return resultado
    }

    fun maiorPontuacao(pontuacao: Array<Int>): Pontos {
        var maiorValor: Int = 0

        var indice = 0
        var iterador = 0
        pontuacao.forEach { ponto ->
            if (ponto >= maiorValor) {
                maiorValor = ponto
                indice = iterador
            }
            iterador++
        }

        return Pontos(maiorValor, indice)
    }

    fun remover(pontuacao: Array<Int>, maiorPontuacao: Int): Array<Int> {
        val novoTamanho = pontuacao.size - 1
        var copy: Array<Int> = Array(novoTamanho) { 0 }

        var iterador = 0
        var antigaLista = 0
        var removido = false
        while (iterador < novoTamanho) {
            if (pontuacao[antigaLista] != maiorPontuacao || removido) {
                copy[iterador] = pontuacao[antigaLista]
                iterador++
                antigaLista++
            } else {
                removido = true
                antigaLista++
            }

        }
        return copy
    }

    fun resto(pontuacao: Array<Int>, k: Int): Array<Int> {
        val size = pontuacao.size
        if (size < k*2) {

            if (size < k) {
                return Array(0) { 0 }
            }

            val resultado: Array<Int> = Array(size - k) { 0 }
            var fatorDeInsercao = 0
            for (i in k until size) {
                resultado[fatorDeInsercao] = pontuacao[i]
                fatorDeInsercao++
            }
            return resultado
        }
        else {
            val valoresRestantes: Array<Int> = Array(pontuacao.size - (k*2)) { 0 }

            var indice = 0

            for (i in 0 until (pontuacao.size - k)) {
                if (i >= k) {
                    valoresRestantes[indice] = pontuacao[i]
                    indice++
                }
            }
            return valoresRestantes
        }
    }

    fun addAll(cabeca: Array<Int>, corpo: Array<Int>?, cauda: Array<Int>): Array<Int> {
        val size = if (corpo != null) {
            cabeca.size + corpo.size + cauda.size
        } else cabeca.size + cauda.size

        val resultado: Array<Int> = Array(size) { 0 }

        for (i in cabeca.indices) {
            resultado[i] = cabeca[i]
        }
        var indice = 0

        corpo?.let {
            if (corpo.size > 0) {
                for (i in cabeca.size until (cabeca.size + corpo.size)) {
                    resultado[i] = corpo[indice]
                    indice++
                }
                indice = 0
            }
            for (i in (cabeca.size + corpo.size) until size) {
                resultado[i] = cauda[indice]
                indice++
            }
            return resultado

        } ?: run {

            for (i in cabeca.size until size) {
                resultado[i] = cauda[indice]
                indice++
            }
            return resultado
        }

    }

    fun Array<Int>.iniciarDe(indice: Int): Array<Int> {
        if (indice > size) return Array(0) { 0 }
        val result: Array<Int> = Array(size - indice) { 0 }

        var fatorDeInsercao = 0
        for (i in indice until size) {
            result[fatorDeInsercao] = this[i]
        }
        return result
    }

    fun formacaoDeTime(pontuacao: Array<Int>, tamanho_do_time: Int, k: Int): Long {
        // Write your code here
        val size = pontuacao.size
        if (size == 0) return 0.toLong()

        if (tamanho_do_time == size) {
            var resultado = 0.toLong()

            pontuacao.forEach {
                resultado += it
            }
            return resultado

        }
        else if (size < k*2) {
            var eleito: Int
            val primeirosPontos = primeirosPontos(pontuacao, k)
            val maiorPontuacaoDePrimeiros = maiorPontuacao(primeirosPontos)
            var removido: Array<Int>?
            eleito = maiorPontuacaoDePrimeiros.pontuacao
            removido = remover(primeirosPontos, maiorPontuacaoDePrimeiros.pontuacao)
            if (tamanho_do_time == 1) {
                return eleito.toLong()
            } else {
                val resultado = addAll(removido, null, resto(pontuacao, k))
                return eleito.toLong() + formacaoDeTime(resultado, tamanho_do_time - 1, k)
            }
        }

        var eleito: Int

        val primeirosPontos = primeirosPontos(pontuacao, k)
        val ultimosPontos = ultimosPontos(pontuacao, k)

        val maiorPontuacaoDePrimeiros = maiorPontuacao(primeirosPontos)
        val maiorPontuacaoDeUltimos = maiorPontuacao(ultimosPontos)

        var removido: Array<Int>?
        var primeiros = false

        if (maiorPontuacaoDePrimeiros.pontuacao == maiorPontuacaoDeUltimos.pontuacao) {
            if (maiorPontuacaoDePrimeiros.indice <= maiorPontuacaoDeUltimos.indice) {
                eleito = maiorPontuacaoDePrimeiros.pontuacao
                removido = remover(primeirosPontos, maiorPontuacaoDePrimeiros.pontuacao)
                primeiros = true
            } else {
                eleito = maiorPontuacaoDeUltimos.pontuacao
                removido = remover(ultimosPontos, maiorPontuacaoDeUltimos.pontuacao)
            }
        } else {
            if (maiorPontuacaoDePrimeiros.pontuacao > maiorPontuacaoDeUltimos.pontuacao) {
                eleito = maiorPontuacaoDePrimeiros.pontuacao
                removido = remover(primeirosPontos, maiorPontuacaoDePrimeiros.pontuacao)
                primeiros = true
            } else {
                eleito = maiorPontuacaoDeUltimos.pontuacao
                removido = remover(ultimosPontos, maiorPontuacaoDeUltimos.pontuacao)
            }
        }

        if (tamanho_do_time == 1) {
            return eleito.toLong()
        } else {
            if (primeiros) {
                val resultado = addAll(removido, resto(pontuacao, k), ultimosPontos)
                return eleito.toLong() + formacaoDeTime(resultado, tamanho_do_time - 1, k)
                /**if (pontuacao.size < k * 2) {
                val cauda = ultimosPontos.iniciarDe((k * 2) - size)
                val resultado = addAll(removido, null, cauda)
                return eleito.toLong() + formacaoDeTime(resultado, tamanho_do_time - 1, k)
                } else {
                val resultado = addAll(removido, resto(pontuacao, k), ultimosPontos)
                return eleito.toLong() + formacaoDeTime(resultado, tamanho_do_time - 1, k)
                }*/
            } else {
                /**if (pontuacao.size < k * 2) {
                val cauda = removido.iniciarDe((k * 2) - size)
                val resultado = addAll(primeirosPontos, null, cauda)
                return eleito.toLong() + formacaoDeTime(resultado, tamanho_do_time - 1, k)
                } else {
                val resultado = addAll(primeirosPontos, resto(pontuacao, k), removido)
                return eleito.toLong() + formacaoDeTime(resultado, tamanho_do_time - 1, k)
                }*/
                val resultado = addAll(primeirosPontos, resto(pontuacao, k), removido)
                return eleito.toLong() + formacaoDeTime(resultado, tamanho_do_time - 1, k)
            }
        }
    }
}
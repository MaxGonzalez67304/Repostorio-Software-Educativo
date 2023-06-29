//EJERCICIOS KOTLKIN TAREA 1
//JESUS MAXIMILIANO GONZALEZ FRIAS
import java.util.*
import kotlin.random.Random

const val MARCADOR = "*"
const val ESCONDIDA = "#"
const val EXPLORADA = " "
const val TAMANIO = 9

val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    println("*** MENU DE EJERCICIOS KOTLIN ***")
    println("1 ... Ejercicio 1")
    println("2 ... Ejercicio 2")
    println("3 ... Ejercicio 3")
    println("4 ... Ejercicio 4")
    println("5 ... Ejercicio 5")
    println("6 ... Ejercicio 6")
    println("7 ... Ejercicio 7")
    println("8 ... Ejercicio 8")
    println("9 ... Ejercicio 9")
    println("10 ... Ejercicio 10")
    println("11 ... Ejercicio 11")
    println("12 ... Ejercicio 12")
    println("Escribe la opción del menú: ")
    val opcion = scanner.nextInt()

    when(opcion) {
        1 -> ejercicio1()

        2 -> ejercicio2()

        3 -> ejercicio3()

        4 -> ejercicio4()

        5 -> ejercicio5()

        6 -> ejercicio6()

        7 -> ejercicio7()

        8 -> ejercicio8()

        9 -> ejercicio9()

        10 -> ejercicio10()

        11 -> ejercicio11()

        12 -> ejercicio12()
    }
}

fun ejercicio1() {
    println("Escribe una palabra para obtener su equivalente en Scrabble")
    val palabra = readLine()!!.toString()
    var puntos = 0

    for (i in palabra){
        when(i){
            'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' , 'a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't' -> puntos += 1
            'D' , 'G' , 'd', 'g' -> puntos += 2
            'B' , 'C' , 'M', 'P' , 'b', 'c', 'm', 'p' -> puntos += 3
            'F' , 'H' , 'V' , 'W', 'Y' , 'f', 'h', 'v', 'w', 'y' -> puntos += 4
            'K' , 'k' -> puntos += 5
            'J' , 'X' , 'j', 'x' -> puntos += 8
            'Q' , 'Z' , 'q', 'z' -> puntos += 10
        }
    }
    println("Los puntos de $palabra son: $puntos")
}

fun ejercicio2() {
    val dna1 = "GAGCCTACTAACGGGAT"
    val dna2 = "CATCGTAATGACGGCCT"
    var distanciaHamming = 0
    for (i in 0 until dna1.length){
        if (dna1[i] != dna2[i]){
            distanciaHamming++
        }
    }
    println(distanciaHamming)
}

fun ejercicio3() {
    val dado = Dado(6)
    val puntos = mutableListOf<Int>()
    for (i in 1..6){
        puntos.add(dado.roll(4))
    }
    
    println("Tus puntos de habilidad son: $puntos")
    val constitution = puntos[2]
    val modificadorConstitucion = (constitution - 10) / 2
    val puntosGolpe = 10 + modificadorConstitucion
    println("El modificador es: $modificadorConstitucion")
    println("Tus puntos de golpe son: $puntosGolpe")
}

fun ejercicio4() {
    val n = 10
    var sumaCuadrados = 0
    var cuadradros = 0

    for (i in 1..n) {
        sumaCuadrados += i * i
        cuadradros += i
    }

    cuadradros *= cuadradros
    println(cuadradros - sumaCuadrados)
}

fun ejercicio5() {
    val frase = "Frase de ejemplo para el ejercicio 1234 they is"
    val numPalabras = frase.split(" ").groupingBy { it }.eachCount()
    println(numPalabras)
}

fun ejercicio6() {
    val cipher = RotationalCipher(13)
    val encriptado = cipher.encrypt("The quick brown fox jumps over the lazy dog.")
    println(encriptado)
    val desencriptado = cipher.decrypt(encriptado)
    println(desencriptado)
}

fun ejercicio7() {
    println("Ejercicio7")
}

fun ejercicio8() {
    println("Ejercicio8")
}

fun ejercicio9() {
    val letra = readLine()!!.first()
    val alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val indice = alfabeto.indexOf(letra)
    val width = indice * 2 + 1
    val height = indice + 1
    val diamante = Array(height) { CharArray(width) { ' ' } }
    for (i in 0 until height) {
        val j = indice - i
        diamante[i][j] = alfabeto[i]
        diamante[i][width - j - 1] = alfabeto[i]
    }
    for (i in 0 until height) {
        println(diamante[i].joinToString("*"))
    }
}

fun ejercicio10() {
    print("Escribe una cadena: ")
    val mensaje = readLine()!!

    for (i in mensaje) {
        when {
            i.isUpperCase() -> print(i)
        }
    }
}

fun ejercicio11() {
    print("Escribe un numero entre 1 - 3999: ")
    val num = Integer.parseInt(readLine())
    val m = arrayOf("", "M", "MM", "MMM")
    val c = arrayOf(
        "", "C", "CC", "CCC", "CD", "D",
        "DC", "DCC", "DCCC", "CM"
    )
    val x = arrayOf(
        "", "X", "XX", "XXX", "XL", "L",
        "LX", "LXX", "LXXX", "XC"
    )
    val i = arrayOf(
        "", "I", "II", "III", "IV", "V",
        "VI", "VII", "VIII", "IX"
    )

    // Converting to roman
    val miles = m[num / 1000]
    val cientos = c[num % 1000 / 100]
    val decenas = x[num % 100 / 10]
    val unidades = i[num % 10]

    print("$miles" + "$cientos" + "$decenas" + "$unidades")
}

fun ejercicio12() {
    print("¿ Cuantas minas desea en el campo ? ")
    val numMinas = scanner.nextInt()

    val cambiaMina = cambiaMina(numMinas)
    cambiaMina.printState()

    do {
        print("Inserte la columna X y la fila Y: ")
        val x = scanner.nextInt() - 1 // column is X coord !!
        val y = scanner.nextInt() - 1 // row is Y coord !!
        val accion = scanner.next()

        when (accion) {
            "libre" -> {
                if (cambiaMina.minaEncontrada(y, x)) {
                    cambiaMina.printState()
                    println("¡Has pisado una mina!")
                    return
                } else {
                    cambiaMina.llenado(y, x)
                    cambiaMina.printState()
                }
            }
            "marcar" -> {
                cambiaMina.cambiarMarcador(y, x)
                cambiaMina.printState()
            }
            else -> continue
        }
    } while (!cambiaMina.ganarJuego())

    println("!Felicidades! Encontraste todas las minas :)")
}

class Dado(val numDados: Int){

    fun roll(dice: Int): Int{
        var total = 0
        for (i in 1..dice){
            total += (1..numDados).random()
        }
        return total
    }
}

data class celda(
    var minaEncontrada: Boolean = false,
    var marcada: Boolean = false,
    var explorada: Boolean = false,
    var numeroMinasCercanas: Int = 0
) {
    override fun toString(): String {
        return when {
            marcada -> MARCADOR
            minaEncontrada -> ESCONDIDA
            explorada -> {
                if (numeroMinasCercanas > 0)
                    numeroMinasCercanas.toString()
                else
                    EXPLORADA
            }
            else -> {
                ESCONDIDA
            }
        }
    }
}

class cambiaMina(numMinas: Int) {
    private val campoMinas = Array(TAMANIO) { Array(TAMANIO) { celda() } }
    private val numMinas = minOf(numMinas, TAMANIO * TAMANIO)

    init {
        llenadoAleatorio()
    }

    private fun llenadoAleatorio() {
        var numMinasColocadas = 0
        while (numMinasColocadas < numMinas) {
            val y = Random.nextInt(TAMANIO)
            val x = Random.nextInt(TAMANIO)
            if (!campoMinas[y][x].minaEncontrada) {
                campoMinas[y][x].minaEncontrada = true
                incrementarMinasCercanas(y, x)
                numMinasColocadas++
            }
        }
    }

    private fun incrementarMinasCercanas(y: Int, x: Int) {
        for (x in (y - 1)..(y + 1)) {
            for (y in (x - 1)..(x + 1)) {
                if (cercaLimite(x, y)) {
                    if (campoMinas[x][y].minaEncontrada) {
                        continue
                    }
                    campoMinas[x][y].numeroMinasCercanas++
                }
            }
        }
    }

    fun printState() {
        println(" |123456789|")
        println("-|---------|")
        for (y in 0 until TAMANIO) {
            print("${y + 1}|")
            for (x in 0 until TAMANIO) {
                print(campoMinas[y][x])
            }
            print("|")
            println()
        }
        println("-|---------|")
    }

    fun cambiarMarcador(y: Int, x: Int) {
        campoMinas[y][x].marcada = !campoMinas[y][x].marcada
    }

    fun minaEncontrada(y: Int, x: Int): Boolean {
        return campoMinas[y][x].minaEncontrada
    }

    fun llenado(y: Int, x: Int) {
        if (cercaLimite(y, x)) {
            val celda = campoMinas[y][x]
            if (!celda.minaEncontrada && !celda.explorada) {
                campoMinas[y][x].explorada = true
                campoMinas[y][x].marcada = false

                llenado(y - 1, x)
                llenado(y + 1, x)
                llenado(y, x - 1)
                llenado(y, x + 1)
            }
        }
    }

    fun ganarJuego(): Boolean {
        var marcadoresCorrectos = 0
        var marcadoresIncorrectos = 0

        for (y in 0 until TAMANIO) {
            for (x in 0 until TAMANIO) {
                val celda = campoMinas[y][x]

                if (celda.marcada && celda.minaEncontrada) {
                    marcadoresCorrectos++
                }
                if (celda.marcada && !celda.minaEncontrada) {
                    marcadoresIncorrectos++
                }
            }
        }
        return marcadoresCorrectos == numMinas && marcadoresIncorrectos == 0
    }

    private fun cercaLimite(x: Int, y: Int) = x in 0 until TAMANIO && y in 0 until TAMANIO
}

class RotationalCipher(private val shift: Int) {
    fun encrypt(message: String): String {
        val builder = StringBuilder()
        for (c in message) {
            if (c.isLetter()) {
                val isUpperCase = c.isUpperCase()
                val index = c.lowercaseChar() - 'a'
                val newIndex = (index + shift) % 26
                val newChar = ('a'.toInt() + newIndex).toChar()
                builder.append(if (isUpperCase) newChar.uppercaseChar() else newChar)
            } else {
                builder.append(c)
            }
        }
        return builder.toString()
    }

    fun decrypt(message: String): String {
        val builder = StringBuilder()
        for (c in message) {
            if (c.isLetter()) {
                val isUpperCase = c.isUpperCase()
                val index = c.lowercaseChar() - 'a'
                val newIndex = (index - shift + 26) % 26
                val newChar = ('a'.toInt() + newIndex).toChar()
                builder.append(if (isUpperCase) newChar.uppercaseChar() else newChar)
            } else {
                builder.append(c)
            }
        }
        return builder.toString()
    }
}
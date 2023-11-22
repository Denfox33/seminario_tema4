// Ejercicio 14: Crea la clase circunferencia. El constructor primario recibirá el
//radio de la circunferencia y el secundario recibirá la posición del centro de la
//circunferencia y un punto cualquiera de la misma. Crear el método longitud()
//y sobrecargar el método toString() de forma que muestre toda la info de la
//circunferencia

import java.lang.Math.sqrt
import kotlin.math.pow


data class Punto(val x: Double, val y: Double)

open class Circunferencia(puntoCentro: Punto, puntoCircunferencia: Punto) {
    val radio: Double = calcularDistancia(puntoCentro, puntoCircunferencia)

    // Calcular la longitud de la circunferencia
    fun longitud(): Double {
        return 2 * Math.PI * radio
    }

    // Sobrecarga del método toString para mostrar toda la información de la circunferencia
    override fun toString(): String {
        return "Circunferencia - Radio: $radio"
    }

    // Función para calcular la distancia entre dos puntos
    private fun calcularDistancia(punto1: Punto, punto2: Punto): Double {
        return sqrt((punto2.x - punto1.x).pow(2) + (punto2.y - punto1.y).pow(2))
    }
}
// Ejercicio 15: Crea la clase Círculo que hereda de circunferencia. Tendrá dos
// constructores, el primero recibirá el radio y el color del círculo y el segundo
// su centro, un punto cualquiera y su color. Crear el método área() y
// sobrecargar el método toString() de forma que muestre toda la info de la
// circunferencia
class Circulo : Circunferencia {
    val color: String

    constructor(radio: Double, color: String) : super(Punto(0.0, 0.0), Punto(radio, 0.0)) {
        this.color = color
    }

    constructor(centro: Punto, puntoCircunferencia: Punto, color: String) :
            super(centro, puntoCircunferencia) {
        this.color = color
    }

    // Método para calcular el área del círculo
    fun area(): Double {
        return Math.PI * radio.pow(2)
    }

    // Sobrecarga del método toString para mostrar toda la información del círculo
    override fun toString(): String {
        return "Círculo - Radio: $radio, Color: $color"
    }
}

fun main() {
    // Ejemplo de uso
    val circulo1 = Circulo(5.0, "Rojo")
    println("Área del círculo1: ${circulo1.area()}")
    println(circulo1)

    val centro = Punto(0.0, 0.0)
    val puntoCirculo2 = Punto(3.0, 4.0)
    val circulo2 = Circulo(centro, puntoCirculo2, "Azul")
    println("Área del círculo2: ${circulo2.area()}")
    println(circulo2)
}

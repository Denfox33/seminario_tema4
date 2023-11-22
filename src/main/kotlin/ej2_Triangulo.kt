import kotlin.math.pow
import kotlin.math.sqrt

// Cada planeta tendrá un nombre, tipo –Rocoso o gaseoso- y una masa. Crea la clase
//sistema solar la cual tendrá una lista de planetas y los métodos .planetaMayor() que
//devuelve el planeta de mayor masa, .planetaMenor() que devuelve el planeta de menor
//masa y .masaMedia() que devuelve la masa media de los planetas del sistema solar.

class Triangulo(val lado1: Double, val lado2: Double, val lado3: Double) {
    // Propiedades
    val perimetro: Double = lado1 + lado2 + lado3
    val tipo: String = calcularTipoTriangulo()

    // Métodos
    fun rectangulo(): Boolean {
        val ladosOrdenados = listOf(lado1, lado2, lado3).sortedDescending()
        return ladosOrdenados[0] == sqrt(ladosOrdenados[1].pow(2) + ladosOrdenados[2].pow(2))
    }

        private fun calcularTipoTriangulo(): String {
        return when {
            lado1 == lado2 && lado2 == lado3 -> "Equilátero"
            lado1 == lado2 || lado1 == lado3 || lado2 == lado3 -> "Isósceles"
            else -> "Escaleno"
        }
    }
}

fun main() {
    val triangulo1 = Triangulo(3.0, 4.0, 5.0)
    val triangulo2 = Triangulo(5.0, 5.0, 5.0)
    val triangulo3 = Triangulo(7.0, 24.0, 25.0)

    println("Triángulo 1:")
    println("Perímetro: ${triangulo1.perimetro}")
    println("Tipo: ${triangulo1.tipo}")
    println("¿Es rectángulo? ${triangulo1.rectangulo()}")

    println("\nTriángulo 2:")
    println("Perímetro: ${triangulo2.perimetro}")
    println("Tipo: ${triangulo2.tipo}")
    println("¿Es rectángulo? ${triangulo2.rectangulo()}")

    println("\nTriángulo 3:")
    println("Perímetro: ${triangulo3.perimetro}")
    println("Tipo: ${triangulo3.tipo}")
    println("¿Es rectángulo? ${triangulo3.rectangulo()}")
}

class Ejercicio17 {

    open class Nota(var id: Int, var cadena: String) {
        // Puedes añadir más propiedades o funciones según sea necesario
        override fun toString(): String {
            return "Nota(id=$id, cadena='$cadena')"
        }
    }

    class NotaAlarma(id: Int, cadena: String, var hora: String) : Nota(id, cadena) {
        // Puedes añadir más propiedades o funciones según sea necesario
        override fun toString(): String {
            return "NotaAlarma(id=$id, cadena='$cadena', hora='$hora')"
        }
    }

    open class BlocNotas {
        // Se utiliza MutableList en lugar de ArrayList para permitir modificaciones
        var listaNotas: MutableList<Nota> = mutableListOf()

        fun contarNotas(): Int {
            return listaNotas.size
        }

        fun introducirNota(nota: Nota) {
            listaNotas.add(nota)
        }

        fun eliminarNota(posicion: Int) {
            if (posicion in 0 until listaNotas.size) {
                listaNotas.removeAt(posicion)
            } else {
                println("La posición no es válida.")
            }
        }

        fun listarNotas() {
            listaNotas.forEachIndexed { index, nota ->
                println("$index: $nota")
            }
        }
    }
}

fun main() {
    // Crear una instancia de Nota y mostrarla
    val nota = Ejercicio17.Nota(1, "Recordatorio")
    println(nota)

    // Crear una instancia de NotaAlarma y mostrarla
    val notaAlarma = Ejercicio17.NotaAlarma(2, "Reunión", "10:00 AM")
    println(notaAlarma)

    // Crear una instancia de BlocNotas y probar las operaciones
    val blocNotas = Ejercicio17.BlocNotas()

    blocNotas.introducirNota(nota)
    blocNotas.introducirNota(notaAlarma)

    println("\nLista de notas:")
    blocNotas.listarNotas()

    println("\nEliminar la primera nota:")
    blocNotas.eliminarNota(0)
    blocNotas.listarNotas()

    println("\nContar el número de notas: ${blocNotas.contarNotas()}")
}

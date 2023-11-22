
// Crea una clase llamada Estudiante que contenga información como nombre, edad y calificaciones. Luego,
//crea una lista de objetos Estudiante y permite a los usuarios agregar nuevos estudiantes, mostrar la
//información de un estudiante en particular y calcular el promedio de calificaciones de todos los estudiantes.

class Estudiante(val nombre: String, val edad: Int, val calificaciones: List<Double>) {
    override fun toString(): String {
        return "Nombre: $nombre, Edad: $edad, Calificaciones: $calificaciones"
    }
}

class Registro {
    private val listaEstudiantes: MutableList<Estudiante> = mutableListOf()

    fun agregarEstudiante(estudiante: Estudiante) {
        listaEstudiantes.add(estudiante)
        println("Estudiante agregado: $estudiante")
    }

    fun informacionEstudiante(nombre: String) {
        val estudiante = listaEstudiantes.find { it.nombre == nombre }
        if (estudiante != null) {
            println("Información del estudiante: $estudiante")
        } else {
            println("No se encontró un estudiante con el nombre $nombre")
        }
    }

    fun calcularPromedioCalificaciones(): Double {
        if (listaEstudiantes.isEmpty()) {
            println("La lista de estudiantes está vacía.")
            return 0.0
        } else {
            val totalCalificaciones = listaEstudiantes.flatMap { it.calificaciones }.sum()
            val totalEstudiantes = listaEstudiantes.size
            return totalCalificaciones / totalEstudiantes
        }
    }
}

fun main() {
    val registroEstudiantes = Registro()

    // Agregar estudiantes
    val estudiante1 = Estudiante("Carlos", 20, listOf(75.5, 61.2, 18.3))
    val estudiante2 = Estudiante("Ana", 22, listOf(67.1, 88.4, 92.9))

    registroEstudiantes.agregarEstudiante(estudiante1)
    registroEstudiantes.agregarEstudiante(estudiante2)

    // Mostrar información de un estudiante
    registroEstudiantes.informacionEstudiante("Carlos")

    // Calcular promedio de calificaciones
    val promedioCalificaciones = registroEstudiantes.calcularPromedioCalificaciones()
    println("Promedio de calificaciones de todos los estudiantes: $promedioCalificaciones")
}

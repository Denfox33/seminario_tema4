class EquipoFutbol(val nombre: String, val pais: String)

fun champions(equipos :List<EquipoFutbol>){
        if (equipos.size%2 !=0){
            return
        }
    //filtar por pais
    val equiposPais= equipos.groupBy{it.pais}
    //mezclarlos equipos
    val equiposMezcladosPorPais = equiposPais.map { it.value.shuffled() }

    // sorteo
    for (i in 0 until equipos.size / 2) {
        val equipoLocal = equiposMezcladosPorPais[i % equiposMezcladosPorPais.size].first()
        val equipoVisitante =
            equiposMezcladosPorPais[(i + equiposMezcladosPorPais.size / 2) % equiposMezcladosPorPais.size].first()

        println("${equipoLocal.nombre} vs ${equipoVisitante.nombre}")
    }
}

fun main() {
    // Crear una lista con 16 equipos de fútbol de países distintos
    val equipos = listOf(
        EquipoFutbol("Real Madrid", "España"),
        EquipoFutbol("FC Barcelona", "España"),
        EquipoFutbol("Bayern Munich", "Alemania"),
        EquipoFutbol("Flamengo", "Brasil"),
        EquipoFutbol("Paris Saint-Germain", "Francia"),
        EquipoFutbol("Marseille", "Francia"),
        EquipoFutbol("Manchester United", "Inglaterra"),
        EquipoFutbol("Liverpool", "Inglaterra"),
        EquipoFutbol("Pumas", "México"),
        EquipoFutbol("América", "México"),
        EquipoFutbol("Ajax", "Países Bajos"),
        EquipoFutbol("Chelsea", "Inglaterra"),
        EquipoFutbol("Porto", "Portugal"),
        EquipoFutbol("Benfica", "Portugal"),
        EquipoFutbol("Boca Juniors", "Argentina"),
        EquipoFutbol("River Plate", "Argentina")
    )
    // Mostrar información de los equipos por pantalla
    for (equipo in equipos){
            println("Nombre: ${equipo.nombre}, País: ${equipo.pais}")

    }
    champions(equipos)
}

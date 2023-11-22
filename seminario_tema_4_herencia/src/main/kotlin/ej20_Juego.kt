// Ejercicio 20: Crea la clase de datos Videojuego, que tendrá nombre, año y plataforma del
//juego. Crea una lista con 8 videojuegos de tres plataformas distintas. Crea una función
//que dada una lista de juegos, un año y una plataforma devuelve los juegos de la lista de
//dicho año y plataforma. La función también debe poder usarse especificando solo el año
//o solo la plataforma.

data class Videojuego(val nombre: String, val año: Int, val plataforma: String)

fun filtrarJuegos(juegos: List<Videojuego>, año: Int? = null, plataforma: String? = null): List<Videojuego> {
    return juegos.filter {
        // Filtra por año y plataforma si se proporcionan; de lo contrario, incluye todos los juegos
        (año == null || it.año == año) && (plataforma == null || it.plataforma.equals(plataforma, ignoreCase = true))
    }
}
fun filtrarJuegos1(
    juegos: List<Videojuego>,años: List<Int>? = null, plataformas: List<String>? = null ): List<Videojuego> {
    return juegos.filter {
        // Filtra por años y plataformas si se proporcionan; de lo contrario, incluye todos los juegos
        (años == null || it.año in años) &&
                (plataformas == null || it.plataforma.equals(plataformas))
    }
}

fun main() {
    // Ejercicio 20: Crear lista de videojuegos
    val listaVideojuegos = listOf(
        Videojuego("Baldur's gate 3", 2023, "PC"),
        Videojuego("Starfield", 2023, "Xbox"),
        Videojuego("Elder Ring", 2022, "PC"),  // Corregir el nombre a "Elder Ring"
        Videojuego("Chronos Before the Ashes", 2022, "Xbox"),
        Videojuego("Dying Light 2 Stay Human", 2021, "PS5"),
        Videojuego("The Medium", 2021, "PC"),
        Videojuego("Ori and the Will of the Wisps", 2020, "PC"),
        Videojuego("Marvel's Spider-Man", 2020, "PS5"),
    )

    // Filtrar juegos por año y plataforma
    val juegosFiltrados = filtrarJuegos(listaVideojuegos, año = 2021, plataforma = "PC")

    // Mostrar juegos filtrados
    println("Ejercicio 20:")
    juegosFiltrados.forEach {
        println("Nombre: ${it.nombre}, Año: ${it.año}, Plataforma: ${it.plataforma}")
    }

    // Ejercicio 21: Filtrar juegos según años y plataformas
    val añosFiltrar = listOf(2020, 2021)
    val plataformasFiltrar = listOf("PS5", "Xbox")

    val juegosFiltrados21 = filtrarJuegos1(listaVideojuegos, años = añosFiltrar, plataformas = plataformasFiltrar)

    // Mostrar juegos filtrados
    println("\nEjercicio 21:")
    juegosFiltrados21.forEach {
        println("Nombre: ${it.nombre}, Año: ${it.año}, Plataforma: ${it.plataforma}")
    }
}

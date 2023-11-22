// Cada planeta tendrá un nombre, tipo –Rocoso o gaseoso- y una masa. Crea la clase
//sistema solar la cual tendrá una lista de planetas y los métodos .planetaMayor() que
//devuelve el planeta de mayor masa, .planetaMenor() que devuelve el planeta de menor
//masa y .masaMedia() que devuelve la masa media de los planetas del sistema solar.

class Planeta(val nombre: String, val tipo: String, val masa: Double)

class SistemaSolar {
     val planetas: MutableList<Planeta> = mutableListOf()

    fun agregarPlaneta(planeta: Planeta) {
        planetas.add(planeta)
    }

    fun planetaMayor(): Planeta? {
        return planetas.maxByOrNull { it.masa }
    }

    fun planetaMenor(): Planeta? {
        return planetas.minByOrNull { it.masa }
    }

    fun masaMedia(): Double {
        if (planetas.isEmpty()) {
            return 0.0
        }
        val sumaMasas = planetas.sumOf { it.masa }
        return sumaMasas / planetas.size
    }

}

fun main() {
    val sistemaSolar = SistemaSolar()

    // Ejercicio 6: Crear los nueve planetas del Sistema Solar
    val mercurio = Planeta("Mercurio", "Rocoso", 0.055)
    val venus = Planeta("Venus", "Rocoso", 0.815)
    val tierra = Planeta("Tierra", "Rocoso", 1.0)
    val marte = Planeta("Marte", "Rocoso", 0.107)
    val jupiter = Planeta("Júpiter", "Gaseoso", 317.8)
    val saturno = Planeta("Saturno", "Gaseoso", 95.2)
    val urano = Planeta("Urano", "Gaseoso", 14.5)
    val neptuno = Planeta("Neptuno", "Gaseoso", 17.1)
    val pluton = Planeta("Plutón", "Rocoso", 0.0022)

    sistemaSolar.agregarPlaneta(mercurio)
    sistemaSolar.agregarPlaneta(venus)
    sistemaSolar.agregarPlaneta(tierra)
    sistemaSolar.agregarPlaneta(marte)
    sistemaSolar.agregarPlaneta(jupiter)
    sistemaSolar.agregarPlaneta(saturno)
    sistemaSolar.agregarPlaneta(urano)
    sistemaSolar.agregarPlaneta(neptuno)
    sistemaSolar.agregarPlaneta(pluton)

    // Ejercicio 7: Muestra por pantalla toda la información de todos los planetas
    for (planeta in sistemaSolar.planetas) {
        println("===============")
        println("Planeta: ${planeta.nombre}, Tipo: ${planeta.tipo}, Masa: ${planeta.masa}")
    }

    // Ejercicio 8: Muestra por pantalla todos los planetas que empiecen por la letra 'M'
    for (planeta in sistemaSolar.planetas) {
        if (planeta.nombre.startsWith("M")) {
            println("===============")
            println("Planeta: ${planeta.nombre}, Tipo: ${planeta.tipo}, Masa: ${planeta.masa}")
        }
    }
    // Ejercicio 9: Muestra por pantalla todos los planetas gaseosos cuya masa sea superior a 20 veces la de la Tierra
    for (planeta in sistemaSolar.planetas) {
        if (planeta.tipo == "Gaseoso" && planeta.masa > 20.0) {
            println("===============")
            println("Planeta: ${planeta.nombre}, Tipo: ${planeta.tipo}, Masa: ${planeta.masa}")
        }
    }

    // Ejercicio 10: Muestra por pantalla la masa media de los planetas del sistema solar
    val masaMedia = sistemaSolar.masaMedia()

    println("===============")
    println("Masa media de los planetas del sistema solar: $masaMedia")

    val planetaMayor = sistemaSolar.planetaMayor()
    val planetaMenor = sistemaSolar.planetaMenor()

    println("===============")
    println("Planeta de mayor masa: ${planetaMayor?.nombre}")
    println("Planeta de menor masa: ${planetaMenor?.nombre}")

    println("Masa media de los planetas: $masaMedia")
}
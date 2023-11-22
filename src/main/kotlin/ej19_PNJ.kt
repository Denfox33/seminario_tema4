// Ejericio 19 :Crea la clase PNJ que representa un personaje en un juego de rol.
//La clase tendrá los atributos, nombre, PV –Puntos de Vida-, PM
//–Puntos mágicos- y LVL. Crea las clases hijas de PNJ Guerrero y
//Mago. Dichas clases implementarán el método levelUp() que
//incrementa el atributo LVL del personaje y sus atributos PV y MP.
//Los guerreros por cada nuevo nivel tendrán un 8% más de PV y un
//1% más de PM mientras que los magos tendrán un 4% más de PV y
//un 3% más de PM. Crear un guerrero de nivel 1 con 400PV y 50PM y
//un mago de nivel 1 con 1600PV y 150PM. Partiendo del hecho de
//que ambos personajes subirán de nivel siempre a la vez ¿en qué
//nivel el guerrero tendrá más PV que el mago?

open class PNJ(var tipo: String, var PV: Double, var PM: Double, var LVL: Int) {

    open fun levelUp() {
        LVL++
    }

    override fun toString(): String {
        return "$tipo (Nivel $LVL) - PV: $PV, PM: $PM"
    }
}

class Guerrero(tipo: String, PV: Double, PM: Double, LVL: Int) : PNJ(tipo, PV, PM, LVL) {

    override fun levelUp() {
        super.levelUp()
        val aumentoPV = PV * 0.08
        val aumentoPM = PM * 0.01
        PV += aumentoPV
        PM += aumentoPM
    }
}

class Mago(tipo: String, PV: Double, PM: Double, LVL: Int) : PNJ(tipo, PV, PM, LVL) {

    override fun levelUp() {
        super.levelUp()
        val aumentoPV = PV * 0.04
        val aumentoPM = PM * 0.03
        PV += aumentoPV
        PM += aumentoPM
    }
}

fun main() {
    val guerrero = Guerrero("Guerrero", 400.0, 50.0, 1)
    val mago = Mago("Mago", 1600.0, 150.0, 1)

    var nivel = 1

    while (guerrero.PV <= mago.PV) {
        guerrero.levelUp()
        mago.levelUp()
        nivel++
    }

    println("En el nivel $nivel, el guerrero tiene más PV que el mago.")
    println("Guerrero: $guerrero")
    println("Mago: $mago")
}

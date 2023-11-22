//  Ejercicio 18: Define una jerarquía de clases que permita almacenar datos sobre los
//planetas y satélites que forman parte del sistema solar (junto con el sol).
//Algunos atributos que puede ser interesante recoger son: la masa del
//cuerpo, su diámetro medio, el período de rotación sobre el propio eje,
//período de traslación alrededor del cuerpo que orbitan, distancia media a
//ese cuerpo, excentricidad de la órbita, etc.
//Define un método que, dado un objeto del sistema solar (planeta o satélite),
//imprima toda la información de que se dispone sobre el mismo.

class Ejercicio18 {

    open class CuerpoCeleste(
        var nombre: String, var masa: Double, var diametro: Double,
        var periodoRotacion: Double, var orbita: Double,
        var distanciaMedia: Double, var estiloOrbita: String
    ) {
        open fun imprimirInformacion() {
            println("Nombre: $nombre")
            println("Masa: $masa")
            println("Diametro: $diametro")
            println("Periodo de rotación: $periodoRotacion")
            println("Órbita alrededor de: $orbita")
            println("Distancia media: $distanciaMedia")
            println("Estilo de órbita: $estiloOrbita")
        }
    }

    class Planeta( nombre: String, masa: Double, diametro: Double,
                   periodoRotacion: Double, orbita: Double, distanciaMedia: Double,
                   estiloOrbita: String, var excentricidadOrbita: Double ) :
        CuerpoCeleste(nombre, masa, diametro, periodoRotacion, orbita, distanciaMedia, estiloOrbita) {
        override fun imprimirInformacion() {
            super.imprimirInformacion()
            println("Excentricidad de la órbita: $excentricidadOrbita")
        }
    }
    class Satelite( nombre: String, masa: Double, diametro: Double,
                    periodoRotacion: Double, orbita: Double, distanciaMedia: Double,
                    estiloOrbita: String, var planetaOrbita: Planeta ) :
        CuerpoCeleste(nombre, masa, diametro, periodoRotacion, orbita, distanciaMedia, estiloOrbita) {
        override fun imprimirInformacion() {
            super.imprimirInformacion()
            println("Planeta alrededor del cual orbita: ${planetaOrbita.nombre}")
        }
    }

    class SistemaSolar(var nombre: String) {
        var cuerposCelestes: HashMap<String, CuerpoCeleste> = HashMap()

        fun añadirCuerpoCeleste(cuerpoCeleste: CuerpoCeleste) {
            cuerposCelestes[cuerpoCeleste.nombre] = cuerpoCeleste
        }

        fun imprimirInformacionSistemaSolar() {
            for (cuerpoCeleste in cuerposCelestes.values) {
                cuerpoCeleste.imprimirInformacion()
                println("===================")
            }
        }
    }
}

fun main() {
    val sistemaSolar = Ejercicio18.SistemaSolar("Nuestro Sistema Solar")

    val marte = Ejercicio18.Planeta("Marte", 6.4171e23, 6779.0, 24.6, 687.0, 227.9e6, "Espiral", 0.0934)
    val luna = Ejercicio18.Satelite("Luna", 7.342e22, 3474.0, 27.3, 27.3, 384.4e3, "Circular", marte)

    sistemaSolar.añadirCuerpoCeleste(marte)
    sistemaSolar.añadirCuerpoCeleste(luna)

    sistemaSolar.imprimirInformacionSistemaSolar()
}
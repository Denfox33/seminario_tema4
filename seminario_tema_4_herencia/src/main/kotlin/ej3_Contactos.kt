
// Crea una clase llamada Contacto que represente la información de un contacto en una lista de contactos. La
//clase debe tener propiedades como nombre, número de teléfono y dirección de correo electrónico. Luego,
//crea una lista de objetos Contacto y permite a los usuarios agregar, eliminar y mostrar contactos.


class Contacto(val nombre: String, val numeroTelefono: String, val direccionCorreo: String) {
    override fun toString(): String {
        return "Nombre: $nombre, Teléfono: $numeroTelefono, Correo: $direccionCorreo"
    }
}

class GestionContactos {
    private val listaContactos: MutableList<Contacto> = mutableListOf()

    fun agregarContacto(contacto: Contacto) {
        listaContactos.add(contacto)
        println("Contacto agregado: $contacto")
    }

    fun eliminarContacto(nombre: String) {
        val contacto = listaContactos.find { it.nombre == nombre }
        if (contacto != null) {
            listaContactos.remove(contacto)
            println("Contacto eliminado: $contacto")
        } else {
            println("No se encontró un contacto con el nombre $nombre")
        }
    }

    fun mostrarContactos() {
        if (listaContactos.isEmpty()) {
            println("La lista de contactos está vacía.")
        } else {
            println("Lista de contactos:")
            listaContactos.forEach { println(it) }
        }
    }
}

fun main() {
    val gestionContactos = GestionContactos()

    // Agregar contactos
    val contacto1 = Contacto("Paloma", "123456789", "paloma@gmail.com")
    val contacto2 = Contacto("Ana", "987654321", "ana@gmail.com")

    gestionContactos.agregarContacto(contacto1)
    gestionContactos.agregarContacto(contacto2)

    // Mostrar contactos
    gestionContactos.mostrarContactos()

    // Eliminar contacto
    gestionContactos.eliminarContacto("Ana")

    // Mostrar contactos después de eliminar
    gestionContactos.mostrarContactos()
}

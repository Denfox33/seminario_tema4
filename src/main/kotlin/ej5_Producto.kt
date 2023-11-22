// Crea una clase Producto que represente productos en un inventario. La clase debe tener propiedades como
//nombre del producto, precio y cantidad en stock. Luego, crea una lista de objetos Producto y permite a los
//usuarios agregar nuevos productos, actualizar el stock y mostrar el inventario.

class Producto(val nombre: String, var precio: Double, var stock: Int) {
    override fun toString(): String {
        return "Producto: $nombre, Precio: $precio, Cantidad en Stock: $stock"
    }
}

class ControlInventario {
    private val listaProductos: MutableList<Producto> = mutableListOf()

    fun agregarProducto(producto: Producto) {
        listaProductos.add(producto)
        println("Producto agregado: $producto")
    }

    fun actualizarStock(nombre: String, nuevaCantidad: Int) {
        val producto = listaProductos.find { it.nombre == nombre }
        if (producto != null) {
            producto.stock = nuevaCantidad
            println("Stock actualizado para $nombre: $nuevaCantidad")
        } else {
            println("No se encontró un producto con el nombre $nombre")
        }
    }

    fun mostrarInventario() {
        if (listaProductos.isEmpty()) {
            println("El inventario está vacío.")
        } else {
            println("Inventario:")
            listaProductos.forEach { println(it) }
        }
    }
}

fun main() {
    val controlInventario = ControlInventario()

    // Agregar productos
    val producto1 = Producto("Psp", 280.0, 12)
    val producto2 = Producto("Nintendo", 90.0, 20)

    controlInventario.agregarProducto(producto1)
    controlInventario.agregarProducto(producto2)

    // Mostrar inventario
    controlInventario.mostrarInventario()

    // Actualizar stock
    controlInventario.actualizarStock("Psp", 8)

    // Mostrar inventario después de actualizar
    controlInventario.mostrarInventario()
}

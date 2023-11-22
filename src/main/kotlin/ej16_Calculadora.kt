class ejercicio16 {

    companion object{ // con esto no es necesario crear una clase en la funcion main

        open  fun suma( numero:Int,  numero2:Int ):Int{
            var res = numero+numero2
            return  res
        }
        open   fun resta( numero:Int,  numero2:Int ):Int{
            var res = numero-numero2
            return  res
        }
        open  fun multiplicacion( numero:Int,  numero2:Int ):Int{
            var res = numero*numero2
            return  res
        }
        open  fun division( numero:Int,  numero2:Int ):Int{
            var res = numero/numero2
            return  res
        }
    }

}

fun main () {

    var numero1=2
    var numero2 =4

    println("valores n1:" + numero1 + "n2: " + numero2)
    println("Suma " + ejercicio16.suma(numero1,numero2))
    println("resta " + ejercicio16.resta(numero1,numero2))
    println("multiplicacion " + ejercicio16.multiplicacion(numero1,numero2))
    println("Division " + ejercicio16.division(numero1,numero2))
}
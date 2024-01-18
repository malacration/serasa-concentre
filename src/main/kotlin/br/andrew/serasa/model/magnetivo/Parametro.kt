package br.andrew.serasa.model.magnetivo

class Parametro(private val name : String,
                private val value : String,
                private val bytes : Int,
                private val pad : Char = ' ',
                private val left : Boolean = false){
    override fun toString(): String {
        return if(left)
            value.padStart(bytes, pad)
        else
            value.padEnd(bytes, pad)
    }


}
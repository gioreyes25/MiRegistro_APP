package cl.duocuc.miregistro.data

import android.content.Context

class RegistroLocal(context: Context) {
    private val datos = context.getSharedPreferences("registro_local", Context.MODE_PRIVATE)

    fun guardar(nombre: String, correo: String) {
        datos.edit()
            .putString("nombre", nombre)
            .putString("correo", correo)
            .apply()
    }

    fun nombre(): String = datos.getString("nombre", "") ?: ""

    fun correo(): String = datos.getString("correo", "") ?: ""
}

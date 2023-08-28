package com.example.proyectocascosmoto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.proyectocascosmoto.actividades.MainActivity
import com.example.proyectocascosmoto.adaptadores.AdaptadorTipos


class LoginActivity : AppCompatActivity() {

    // Variables para vincular con la vista
    lateinit var etUsuario: EditText
    lateinit var etPass: EditText
    lateinit var cbRecordar: CheckBox
    lateinit var btnRegistrar: Button
    lateinit var btnIniciar: Button

    // Funcion que se ejecuta al iniciar un Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Vinculamos las variables con los IDs correspondientes a la vista
        etUsuario = findViewById(R.id.etUsuario)
        etPass = findViewById(R.id.etPass)
        cbRecordar = findViewById(R.id.cbRecordar)
        btnIniciar = findViewById(R.id.botonIniciar)
        btnRegistrar = findViewById(R.id.botonRegistrar)

        //registrar usuario
        //Agregamos funcionalidad al Boton
        btnRegistrar.setOnClickListener {
            // Mostramos un mensaje
            Toast.makeText(this, "Registro de Usuarios", Toast.LENGTH_SHORT).show()

            val pantallaRegistrar = Intent(this, RegisterActivity::class.java)
            // Cambiamos de pantalla
            startActivity(pantallaRegistrar)
            // Eliminamos la Activity actual para sacarla de la Pila

        }


        //INICIAR SESION
        //Agregamos funcionalidad al Boton
        btnIniciar.setOnClickListener {
            var mensaje = "Iniciar Sesion"
            // Obtenemos el dato que se ingreso en la vista
            var nombreUsuario = etUsuario.text.toString()
            if(nombreUsuario.isEmpty() || etPass.text.toString().isEmpty()){
                mensaje+= " - Faltan Datos"
            }else {
                mensaje+= " - Datos OK"
                // Verificamos si esta tildado el CechBox
                if(cbRecordar.isChecked)
                    mensaje+= "- Recordar Usuario"

                // Indicamos a que pantalla queremos ir
                val intentMain = Intent(this,MainActivity::class.java)
                // Agregamos datos que queremos pasar a la proxima pantalla
                intentMain.putExtra("nombre", nombreUsuario)
                // Cambiamos de pantalla
                startActivity(intentMain)

                // Eliminamos la Activity actual para sacarla de la Pila

            }
        }
    }
}

package cl.duocuc.miregistro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cl.duocuc.miregistro.ui.screens.FormularioScreen
import cl.duocuc.miregistro.ui.screens.PerfilScreen
import cl.duocuc.miregistro.ui.screens.RecursosScreen
import cl.duocuc.miregistro.ui.theme.MiRegistroTheme

private val secciones = listOf("Registro", "Perfil", "Recursos")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiRegistroTheme {
                var seleccion by rememberSaveable { mutableIntStateOf(0) }

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            secciones.forEachIndexed { indice, nombre ->
                                NavigationBarItem(
                                    selected = seleccion == indice,
                                    onClick = { seleccion = indice },
                                    icon = { Text(listOf("✎", "☺", "▣")[indice]) },
                                    label = { Text(nombre) }
                                )
                            }
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.background
                ) { espacio ->
                    AnimatedContent(
                        targetState = seleccion,
                        modifier = Modifier.padding(espacio),
                        transitionSpec = { fadeIn() togetherWith fadeOut() },
                        label = "Cambio de pantalla"
                    ) { pantalla ->
                        when (pantalla) {
                            0 -> FormularioScreen()
                            1 -> PerfilScreen()
                            else -> RecursosScreen()
                        }
                    }
                }
            }
        }
    }
}

package cl.duocuc.miregistro.ui.screens

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun RecursosScreen() {
    val contexto = LocalContext.current
    var imagen by remember { mutableStateOf<Bitmap?>(null) }
    var mensaje by remember { mutableStateOf("Elige una foto o abre la cámara") }

    val elegirFoto = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            imagen = contexto.contentResolver.openInputStream(uri)?.use { BitmapFactory.decodeStream(it) }
            mensaje = if (imagen != null) "Foto cargada correctamente" else "No se pudo abrir la foto"
        }
    }

    val abrirCamara = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { foto ->
        if (foto != null) {
            imagen = foto
            mensaje = "Foto tomada con la cámara"
        } else {
            mensaje = "No se tomó ninguna foto"
        }
    }

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Recursos del teléfono", style = MaterialTheme.typography.headlineSmall)
        Text("MiRegistro permite elegir una imagen existente o tomar una foto nueva.")

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (imagen == null) {
                    Text("Aquí aparecerá tu imagen", modifier = Modifier.padding(24.dp))
                } else {
                    Image(
                        bitmap = imagen!!.asImageBitmap(),
                        contentDescription = "Imagen seleccionada",
                        modifier = Modifier.fillMaxWidth().height(240.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                Text(mensaje, style = MaterialTheme.typography.bodyMedium)
            }
        }

        Button(onClick = { elegirFoto.launch("image/*") }, modifier = Modifier.fillMaxWidth()) {
            Text("Elegir foto")
        }
        OutlinedButton(onClick = { abrirCamara.launch(null) }, modifier = Modifier.fillMaxWidth()) {
            Text("Abrir cámara")
        }
    }
}

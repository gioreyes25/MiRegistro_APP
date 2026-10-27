# MiRegistro

Aplicación Android para crear un registro personal, revisar una pantalla de perfil y utilizar recursos del teléfono.

## Funciones

- Formulario con nombre, correo, contraseña, nivel de experiencia, preferencias y aceptación de términos.
- Validaciones y mensajes de error por campo.
- Navegación inferior entre Registro, Perfil y Recursos.
- Guardado local del nombre y el correo. Al volver a abrir la app, esos dos datos aparecen en el formulario.
- Contraseña no guardada en el almacenamiento local.
- Selección de una imagen del dispositivo.
- Captura de una foto mediante la cámara del teléfono.
- Transición animada entre pantallas y mensaje animado cuando el registro es válido.
- Interfaz con Material 3 y tema propio en tonos morados, turquesa y coral.
- Organización por modelo, pantallas, componentes, ViewModels, tema y almacenamiento local.

## Tecnologías

- Kotlin
- Android Studio
- Jetpack Compose
- Material 3
- MVVM con ViewModel y StateFlow
- SharedPreferences para persistencia local
- Activity Result API para la cámara y el selector de imágenes

## Cómo ejecutar

1. Descomprime el proyecto y abre la carpeta `MiRegistro` en Android Studio.
2. Espera a que termine la sincronización de Gradle.
3. Inicia un emulador o conecta un dispositivo Android.
4. Ejecuta la configuración `app`.
5. En la pestaña Recursos, prueba tanto Elegir foto como Abrir cámara.
6. Registra un nombre y correo válidos, cierra y vuelve a abrir la app para comprobar que se conservan.

## Estructura principal

- `MainActivity.kt`: entrada y navegación principal.
- `model`: modelos y estado de la interfaz.
- `viewmodel`: estado y validación del formulario y del perfil.
- `data/RegistroLocal.kt`: lectura y guardado de los datos locales.
- `ui/screens`: pantallas de registro, perfil y recursos del teléfono.
- `ui/components`: componentes reutilizables.
- `ui/theme`: colores, tipografía y tema Material 3.

## Lista de revisión de la rúbrica

- [x] Interfaz organizada con Material 3.
- [x] Navegación funcional entre tres secciones.
- [x] Validación del formulario desde el ViewModel.
- [x] Mensajes visuales de error y confirmación.
- [x] Gestión de estado con StateFlow.
- [x] Persistencia local del nombre y correo.
- [x] Dos recursos nativos: selector de imágenes y cámara.
- [x] Animaciones de navegación y confirmación.
- [ ] Repositorio público de GitHub con commits reales del equipo.
- [ ] Tablero de Trello o similar con tareas y responsables.
- [ ] Completar nombres de los integrantes en la entrega y en AVA.
- [ ] Ejecutar y probar el proyecto en Android Studio antes de entregar.

Los elementos de GitHub, Trello, pruebas en el dispositivo y entrega en AVA requieren acciones del equipo; no se consideran completados por incluir este archivo.

## Plan de trabajo sugerido para Trello

1. Revisar y ejecutar el proyecto base — integrante 1.
2. Completar navegación y diseño — integrante 1.
3. Probar validaciones y persistencia local — integrante 2.
4. Probar cámara y selector de imágenes — integrante 2.
5. Revisar accesibilidad, errores y pantallas — ambos.
6. Preparar README, capturas y entrega — ambos.

## Integrantes

- Integrante 1: completar nombre.
- Integrante 2: completar nombre.

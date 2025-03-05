<h1 align="center" style="font-weight: bold; display:flex; justify-content:space-between; text-align:center; align-items:center">
  <div align="center" style="width:100%; text-decoration:underline">
  Proyecto Ingeniería de Software
  </div>
  <img src="https://upload.wikimedia.org/wikipedia/commons/f/f4/Logo_Universidad_Central_de_Venezuela.svg" width="60">
</h1>

<section>
<h2 align="center">Miembros del Equipo</h2>

El **Equipo de Trabajo** está conformado por:

- Oscar Allen.
- Abigail Araujo.
- Javier Hernández.
- Alejandro Marín.
- Rolando Uzcátegui.
</section>

<section>
  <h2 align="center" style="text-">Modelo de Dominio</h2>
  <div align="center">
    <h4 style="text-decoration:underline">Diagrama de Clases</h4>
    <img src="docs/scenariosView/Diagrama Clases.png" alt="Diagrama-Clases" style="border-radius:5px;">
  </div>
  <div align="center">
    <h4 style="text-decoration:underline">Diagrama de Estado</h4>
    <img src="docs/scenariosView/Diagrama Estado.png" alt="Diagrama-Estado" style="border-radius:5px;">
  </div>
  <div align="center">
    <h4 style="text-decoration:underline"> Esquema de Pantallas</h4>
    <img src="docs/scenariosView/esquema-de-pantallas/UC2 - Login.png" alt="pantalla" style="border-radius:5px;">
    <img src="docs/scenariosView/esquema-de-pantallas/UC3 - Edit Profile.png" alt="pantalla" style="border-radius:5px;">
    <img src="docs/scenariosView/esquema-de-pantallas/UC4 - Visualizar Calendario.png" alt="pantalla" style="border-radius:5px;">
    <img src="docs/scenariosView/esquema-de-pantallas/UC1 - Register.png" alt="pantalla" style="border-radius:5px;">
    <img src="docs/scenariosView/esquema-de-pantallas/UC5 - Visualizar Publicación.png" alt="pantalla" style="border-radius:5px;">
    <img src="docs/scenariosView/esquema-de-pantallas/UC6 - Visualizar Evento.png" alt="pantalla" style="border-radius:5px;">
    <img src="docs/scenariosView/esquema-de-pantallas/UC7 - Crear Publicacion.png" alt="pantalla" style="border-radius:5px;">
    <img src="docs/scenariosView/esquema-de-pantallas/UC8 - Editar Publicacion.png" alt="pantalla" style="border-radius:5px;">
    <img src="docs/scenariosView/esquema-de-pantallas/UC9 - Eliminar Publicacion.png" alt="pantalla" style="border-radius:5px;">
    <img src="docs/scenariosView/esquema-de-pantallas/UC10 - Crear Evento.png" alt="pantalla" style="border-radius:5px;">
    <img src="docs/scenariosView/esquema-de-pantallas/UC11 - Editar Evento.png" alt="pantalla" style="border-radius:5px;">
    <img src="docs/scenariosView/esquema-de-pantallas/UC12 - Eliminar Evento.png" alt="pantalla" style="border-radius:5px;">
    <img src="docs/scenariosView/esquema-de-pantallas/UC14 - Moderacion.png" alt="pantalla" style="border-radius:5px;">
  </div>
</section>
<section>
  <h2 align="center" style="text-">Modelo de Análisis</h2>
  <div align="center">
    <h4 style="text-decoration:underline">
    Diagrama de Clases
    </h4>
    <img src="docs/logicalView/analisysView/DiagramClass.png" alt="Diagrama-Clases" style="border-radius:5px">
  </div>
  <div align="center">
    <h4 style="text-decoration:underline">
      Diagrama de Colaboración de los Casos de Uso
    </h4>
    <img src="docs/scenariosView/Diagrama Colaboracion.png" alt="Diagrama-Colaboracion" style="border-radius:5px;">
  </div>
  <div align="center">
    <h4 style="text-decoration:underline">
    Diagrama de Análisis de los Casos de Uso
    </h4>
    <img src="docs/scenariosView/Diagrama Analisis.png" alt="Diagrama-Analisis" style="border-radius:5px;">
  </div>
  <div align="center">
    <h4 style="text-decoration:underline">
    Diagrama de Paquete de Análisis Final
    </h4>
    <img src="docs/logicalView/analisysView/DiagramPackage.png" alt="Diagrama-Paquetes" style="border-radius:5px">
  </div>
</section>
<section>
  <h2 align="center" style="text-">Modelo de Diseño</h2>
  <div align="center">
    <h4 style="text-decoration:underline">
    Diagrama de Clases UC7
    </h4>
    <img src="docs/logicalView/designView/DiagramClass.png" alt="Diagrama-Clases" style="border-radius:5px">
  </div>
  <div align="center">
    <h4 style="text-decoration:underline">
      Diagrama de Secuencia UC7
    </h4>
    <img src="docs/logicalView/designView/DiagramSequence.jpg" alt="Diagrama-Secuencia" style="border-radius:5px;">
  </div>
    <div align="center">
    <h4 style="text-decoration:underline">
      Diagrama de Trazas UC7
    </h4>
    <img src="docs/logicalView/designView/DiagramTrace.jpg" alt="Diagrama-Secuencia" style="border-radius:5px;">
  </div>
</section>
<section>
  <h2 align="center" style="text-">Modelo de Despliegue</h2>
  <div align="center">
    <h4 style="text-decoration:underline">
    Diagrama de Despliegue
    </h4>
    <img src="docs/physicalView/DiagramDeployment.png" alt="Diagrama-Clases" style="border-radius:5px">
  </div>
</section>
<section>
  <h2 align="center" style="text-">Modelo de Implementación</h2>
  <div align="center">
    Este es un proyecto Java que utiliza Java Swing para la interfaz gráfica de usuario y SQLite para la base de datos. Está configurado utilizando Maven para la gestión de dependencias y la construcción del proyecto.

<br>

**Librerías Utilizadas:**

- **JUnit**: Biblioteca para pruebas unitarias.

  - Grupo: `junit`
  - Artefacto: `junit`
  - Versión: `3.8.1`

- **SQLite JDBC**: Biblioteca para conectarse a la base de datos SQLite.

  - Grupo: `org.xerial`
  - Artefacto: `sqlite-jdbc`
  - Versión: `3.36.0.3`

<br>

**Instrucciones para Ejecutar el Proyecto:**

**Prerrequisitos**

- Java 17 (JDK)
- Apache Maven

1. **Clona el repositorio:**

   ```sh
   git clone https://github.com/RolandoU548/Plataforma-Virtual.git
   ```

2. **Compila el proyecto con Maven:**

   ```sh
   mvn clean compile
   ```

3. **Ejecuta el proyecto con Maven:**

   ```sh
   mvn exec:java
   ```

Adicionalmente, se puede crear un archivo JAR con todas las dependencias. Para ello ejecuta el siguiente comando:

```sh
mvn package
```

El archivo JAR se encontrará en el directorio target con el nombre PlataformaDigital-1.0-SNAPSHOT-jar-with-dependencies.jar.

  </div>
</section>

<section>
  <h2 align="center" style="text-">Modelo de Pruebas</h2>

- StringUtils
  - testNullInput()
  - testEmptyString()
  - testSpecialCharacters()
  - testSingleLowerCaseLetter()
  - testSingleUpperCaseLetter()
  - testMultipleLowerCaseLetters()
  - testMultipleUpperCaseLetters()
  - testMultipleMixedCaseLetters()
  </section>

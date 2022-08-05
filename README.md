# automationPractice

**ID EJERCICIO: PFA_03_QAN
- Rama: Main
- Comando de ejecución: gradle test --tests TestRunnersRegistro
- Pagina automatizada: http://automationpractice.com/index.php
- Modulo automatizado: registro.
- Java: Version 11.0.13
- Gradle: Version 5.2
- Sistema: Windows
- Patron de diseño: POM
- Framework: serenity, gherkin, cucumber.
- Framework adicionales: libreria Faker.
- Lenguaje programacion: Java.
- Version navegador en el que se ejecuto: ChromeDriver version 103.0.5060.134
- La mayor parte de las dependencias que estan en el bluid.gradle estan actualizadas
- El proyecto esta configurado para ejecutar en cualquier maquina y detectar el navegador y version para Chrome
- Se conecta remotamente para obtener el driveChrome, no contiene driveChrome.exe
- Contiene  archivos llamados serenity.conf para dinamizar y serenity.properties para el uso de las propiedades tanto para chrome como serenity  

# Sumario:
Se realiza proyecto de automatización en patron de diseño Screenplay, se automatizo una pagina para realizar registro de una cuenta, los datos que se utilizaron, todos son falsificados o de relleno por medio de la libreria FAKER se implementaron los datos, haciendo que cada vez que se ejecute el test cree una cuenta distinta al igual al llenar los datos del formulario utilizando informacion random, tambien es de resaltar que se construyo de forma dinamica la logica, haciendo enfacis en los principios de responsabilidad unica, abierto y cerrado, segregacion de interfaces, es de aclarar que los principios son faciles de aplicar pero dificiles de mantener, por ultimo se ejecuto un analicis de codigo estatico con la herramienta SonarLink y este arrojo codesmell y bug, los bug ya fueron solucionado solo quedaron pocos codesmell menores o baja priorida.
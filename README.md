# *Contador de Vocales, Consonantes y Palabras*  
## Proyecto final del Trimestre 1 para la asignatura PsP. 

Este repositorio contiene una aplicación hecha en java con IntelliJ, que permite contabilizar las vocales y consonantes que existen en un fichero específico.  

### Características.

- El fichero del que se contabilizarán vocales y consonantes se recibirá como parámetro en la configuración de IntelliJ.
- Se crea un proceso hijo para contabilizar las vocales y otro para las consonantes.
- Cada proceso hijo almacena en un fichero diferente el número de vocales o consonantes contabilizadas.
- Ambos procesos hijos reciben desde el proceso padre la petición para ejecutar la operación de contabilizar.
- Una vez finalizan su ejecución ambos procesos hijos, el proceso padre se encarga de visualizar los resultados obtenidos por ambos.
- Además, se cuenta cada letra y se muestra una lista ordenada con un TreeMap.
- Se cuenta el número de palabras.
- Se debe introducir la palabra 'contabilizar' para ejecutar el programa.

### Requisitos
- Java 8 o superior
- IntelliJ

### Ejecución
1. Clonar este repositorio.
2. Abrir el proyecto en IntelliJ.
3. Configurar el fichero a leer en la configuración de IntelliJ.
4. Ejecutar el programa y escribir la palabra 'contabilizar' para iniciar la contabilización de vocales y consonantes.
5. Los resultados se mostrarán en los ficheros correspondientes y en consola.


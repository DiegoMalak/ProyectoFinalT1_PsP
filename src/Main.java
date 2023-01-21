import java.io.*;
import java.util.Scanner;

public class Main {

    // Antes de empezar debemos configurar el valor de args para que sea igual
    // al fichero que queremos leer, ya que en este caso nos lo pide el enunciado.

    // ******* PARA INTELLIJ *******
    // Para ello vamos a la pestaña Run y clicamos en Edit Configurations.
    // Y seleccionamos el Main y en la parte de Build and Run le ponemos el nombre del fichero
    // que queremos leer.

    public static void main(String[] args) {
        // Primero se lee el archivo de entrada, si no se pone el nombre del archivo
        // hacemos un sout para indicando que no se ha ingresado el nombre del archivo.
        if (args.length == 0) {
            System.out.println("No se ha especificado el archivo de entrada");
            System.exit(1);
        }

        String fileName = args[0];

        // Se crea un objeto de la clase Scanner para leer el archivo de entrada.
        Scanner scanner = new Scanner(System.in);

        // Hacemos un try-catch para leer el archivo de entrada.
        try {
// ********************************************************************************************
// PRIMER HIJO
// ********************************************************************************************
            // Creamos el primer ProcessBuilder para ejecutar el archivo ContabilizadorVocales.
            // Le ponemos la ruta del archivo ContabilizadorVocales.jar
            ProcessBuilder pbHijoVocales = new ProcessBuilder("java", "-jar", "jars\\ContabilizadorVocales.jar");

            // Redirigimos la salida del proceso hijo vocales al fichero vocales.txt y en
            // caso de que de error lo redirigimos al fichero vocales_error.txt
            // Creamos el fichero vocales.txt y vocales_error.txt
            pbHijoVocales.redirectOutput(new File("vocales.txt"));
            pbHijoVocales.redirectError(new File("vocales_errores.txt"));

            // Arrancamos el proceso hijo vocales y lo guardamos en una variable.
            Process hijoVocales = pbHijoVocales.start();

            // Obtenemos el stdout (salida standard out) del proceso hijo vocales.
            BufferedReader salidaHijo1 = new BufferedReader(new InputStreamReader(hijoVocales.getInputStream()));

            // Entrada standard del proceso hijo vocales.
            PrintStream entradaHijo1 = new PrintStream(hijoVocales.getOutputStream());

// ********************************************************************************************
// SEGUNDO HIJO
// ********************************************************************************************
            // Creamos el segundo ProcessBuilder para ejecutar el archivo ContabilizadorConsonantes.
            // Le ponemos la ruta del archivo ContabilizadorConsonantes.jar
            ProcessBuilder pbHijoConsonantes = new ProcessBuilder("java", "-jar", "jars\\ContabilizadorConsonantes.jar");

            // Redirigimos la salida del proceso hijo consonantes al fichero consonantes.txt y en
            // caso de que de error lo redirigimos al fichero consonantes_error.txt
            pbHijoConsonantes.redirectOutput(new File("consonantes.txt"));
            pbHijoConsonantes.redirectError(new File("consonantes_errores.txt"));

            // Arrancamos el proceso hijo consonantes y lo guardamos en una variable.
            Process hijoConsonantes = pbHijoConsonantes.start();

            // Obtenemos el stdout (salida standard out) del proceso hijo
            BufferedReader salidaHijo2 = new BufferedReader(new InputStreamReader(hijoConsonantes.getInputStream()));

            // Entrada standard del proceso hijo
            PrintStream entradaHijo2 = new PrintStream(hijoConsonantes.getOutputStream());

// ********************************************************************************************
// TERCER HIJO
// ********************************************************************************************
            // Creamos el tercer ProcessBuilder para ejecutar el archivo ContabilizadorNumeros.
            // Le ponemos la ruta del archivo ContabilizadorNumeros.jar
            ProcessBuilder pbHijoPalabras = new ProcessBuilder("java", "-jar", "jars\\ContabilizadorPalabras.jar");

            // Redirigimos la salida del proceso hijo palabras al fichero palabras.txt y en
            // caso de que de error lo redirigimos al fichero palabras_error.txt
            pbHijoPalabras.redirectOutput(new File("palabras.txt"));
            pbHijoPalabras.redirectError(new File("palabras_errores.txt"));

            // Arrancamos el proceso hijo palabras y lo guardamos en una variable.
            Process hijoPalabras = pbHijoPalabras.start();

            // Obtenemos el stdout (salida standard out) del proceso hijo
            BufferedReader salidaHijo3 = new BufferedReader(new InputStreamReader(hijoPalabras.getInputStream()));

            // Entrada standard del proceso hijo palabras.
            PrintStream entradaHijo3 = new PrintStream(hijoPalabras.getOutputStream());

            // Hacemos un do-while para que nos muestre un mensaje que indica que escribas la palabra
            // "contabilizar" para que empiece a contar las vocales y consonantes.
            // Va a repetirse el do hasta que escribamos la palabra "contabilizar" que ejecutará
            // el código de después del do-while.
            do {
                System.out.println("Introduce la palabra 'contabilizar' para que los hijos empiecen a trabajar...");
            } while (!scanner.nextLine().equals("contabilizar"));

            // Con la linea de código siguiente le decimos al proceso hijo vocales
            // que empiece a contar las vocales.
            // Lo hace de tal manera que le llega la palabra "contabilizar" y con él .lineSeparator()
            // simula un salto de línea (enter).
            // El .getBytes() nos permite convertir el String en un array de bytes.
            entradaHijo1.write("contabilizar".getBytes());
            // El .lineSeparator() nos da el separador de línea del sistema operativo. (enter o \n)
            entradaHijo1.write(System.lineSeparator().getBytes());
            // Con el flush le decimos que se ejecute el código anterior.
            entradaHijo1.flush();

            // Con la linea de codigo siguiente le pasamos el nombre del archivo de entrada
            // al proceso hijo vocales.
            // Lo hace de tal manera que le llega el nombre del archivo de entrada y con él .lineSeparator()
            // simula un salto de línea (enter).
            // El .getBytes() nos permite pasar el nombre del archivo de entrada a bytes.
            entradaHijo1.write(fileName.getBytes());
            // El .lineSeparator() nos da el separador de línea del sistema operativo. (enter o \n)
            entradaHijo1.write(System.lineSeparator().getBytes());
            // Con el flush le decimos que se ejecute el código anterior.
            entradaHijo1.flush();

            // Con la linea de código siguiente le decimos al proceso hijo consonantes
            // que empiece a contar las consonantes.

            entradaHijo2.write("contabilizar".getBytes());
            // El .lineSeparator() nos da el separador de línea del sistema operativo. (enter o \n)
            entradaHijo2.write(System.lineSeparator().getBytes());
            // Con el flush le decimos que se ejecute el código anterior.
            entradaHijo2.flush();

            // Con la linea de codigo siguiente le pasamos el nombre del archivo de entrada
            // al proceso hijo consonantes.
            entradaHijo2.write(fileName.getBytes());
            // El .lineSeparator() nos da el separador de línea del sistema operativo. (enter o \n)
            entradaHijo2.write(System.lineSeparator().getBytes());
            // Con el flush le decimos que se ejecute el código anterior.
            entradaHijo2.flush();

            // Con la linea de código siguiente le decimos al proceso hijo palabras
            // que empiece a contar las palabras.
            // Lo hace de tal manera que le llega la palabra "contabilizar" y con él .lineSeparator()
            // simula un salto de línea (enter).
            entradaHijo3.write("contabilizar".getBytes());
            // El .lineSeparator() nos da el separador de línea del sistema operativo. (enter o \n)
            entradaHijo3.write(System.lineSeparator().getBytes());
            // Con el flush le decimos que se ejecute el código anterior.
            entradaHijo3.flush();

            // Con la linea de codigo siguiente le pasamos el nombre del archivo de entrada
            // al proceso hijo palabras.
            // Lo hace de tal manera que le llega el nombre del archivo de entrada y con él .lineSeparator()
            // simula un salto de línea (enter).
            entradaHijo3.write(fileName.getBytes());
            // El .lineSeparator() nos da el separador de línea del sistema operativo. (enter o \n)
            entradaHijo3.write(System.lineSeparator().getBytes());
            // Con el flush le decimos que se ejecute el código anterior.
            entradaHijo3.flush();

            // Esperamos a que los hijos terminen.
            hijoVocales.waitFor();
            hijoConsonantes.waitFor();
            hijoPalabras.waitFor();

            // Leemos los ficheros de salida de los hijos y los mostramos por pantalla.
            String linea;

            BufferedReader brVocales = new BufferedReader(new FileReader("vocales.txt"));
            System.out.println("Vocales:");
            while ( (linea = brVocales.readLine()) != null ) {
                System.out.println(linea);
            }

            BufferedReader brConsonantes = new BufferedReader(new FileReader("consonantes.txt"));
            System.out.println("Consonantes:");
            while ( (linea = brConsonantes.readLine()) != null ) {
                System.out.println(linea);
            }

            BufferedReader brPalabras = new BufferedReader(new FileReader("palabras.txt"));
            System.out.println("Palabras:");
            while ( (linea = brPalabras.readLine()) != null ) {
                System.out.println(linea);
            }

            // Cerramos los BufferedReader.
            brVocales.close();
            brConsonantes.close();
            brPalabras.close();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}





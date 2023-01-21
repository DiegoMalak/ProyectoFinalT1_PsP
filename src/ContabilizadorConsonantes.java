import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ContabilizadorConsonantes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String entrada;

        do {
            entrada = scanner.nextLine();
        } while (!entrada.equals("contabilizar"));

        // Aquí almacenaremos el nombre del archivo que se recibe por la entrada estándar.
        String filename = scanner.nextLine();

        // Creamos un TreeMap para almacenar las consonantes y su frecuencia de aparición.
        TreeMap<Character, Integer> mapConsonantes = new TreeMap<>();
        // Creamos una lista con las vocales válidas.
        List<Character> listaConsonantesValidas = Arrays.asList('b', 'c', 'd', 'f', 'g',
                'h', 'j', 'k', 'l', 'm', 'n', 'ñ', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z');

        int consonantes = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Recorremos la línea letra a letra.
                for (int i = 0; i < line.length(); i++) {
                    // Obtenemos la letra en minúscula.
                    char c = line.toLowerCase().charAt(i);
                    // Comprobamos si la letra es una consonante válida.
                    if (listaConsonantesValidas.contains(c)) {
                        // Incrementamos el contador de consonantes.
                        consonantes++;
                        // Obtenemos la frecuencia de aparición de la consonante.
                        Integer veces = mapConsonantes.get(c);
                        // Si el valor es null, significa que no ha aparecido previamente.
                        if (veces == null) {
                            // Asignamos el valor 0.
                            veces = 0;
                        }
                        // Incrementamos el valor de la frecuencia de aparición.
                        veces++;
                        // Guardamos el valor en el TreeMap.
                        mapConsonantes.put(c, veces);
                    }
                }
            }
            // Imprimimos el resultado.
            System.out.println(consonantes);
            System.out.println(mapConsonantes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

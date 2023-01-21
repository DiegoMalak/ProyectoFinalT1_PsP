import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ContabilizadorVocales {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String entrada;

        do {
            entrada = scanner.nextLine();
        } while (!entrada.equals("contabilizar"));

        String filename = scanner.nextLine();

        // Hacemos un TreeMap para que nos guarde las entradas en orden alfabetico y
        // no tengamos que ordenarlas después.
        TreeMap<Character, Integer> mapVocales = new TreeMap<>();
        // Inicializamos la lista con las vocales.
        // Esto es para no tener que poner tantas líneas de declaración de variables
        // como vocales hay.
        List<Character> listaVocalesValidas = Arrays.asList('a', 'e', 'i', 'o', 'u');

        // Creamos un contador para las vocales.
        int vocales = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Recorremos la línea letra a letra.
                for (int i = 0; i < line.length(); i++) {
                    // Obtenemos la letra en minúscula.
                    char c = line.toLowerCase().charAt(i);

                    // Comprobamos si la letra es una vocal válida,
                    // que se encuentra en la lista de vocales creada.
                    // Si es así entra en el if.
                    if (listaVocalesValidas.contains(c)) {
                        // Incrementamos el contador de vocales.
                        vocales++;
                        // Obtenemos el número de veces que ha aparecido la vocal anteriormente.
                        Integer veces = mapVocales.get(c);
                        // Si el valor es null, significa que no ha aparecido previamente.
                        if (veces == null) {
                            // Asignamos el valor 0.
                            veces = 0;
                        }
                        // Incrementamos el valor de las veces que ha aparecido.
                        veces++;
                        // Guardamos el valor en el TreeMap sobreescribiendo.
                        mapVocales.put(c, veces);
                    }
                }
            }
            // Imprimimos el resultado.
            System.out.println(vocales);
            System.out.println(mapVocales);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

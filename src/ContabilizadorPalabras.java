import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class ContabilizadorPalabras {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String entrada;

        do {
            entrada = scanner.nextLine();
        } while (!entrada.equals("contabilizar"));

        String filename = scanner.nextLine();

        int palabras = 0, pos;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                //Si la linea esta vacia no hacemos nada.
                if(line.isEmpty()){
                    palabras = 0;
                }else{
                    //Si la linea no esta vacia
                    pos = line.indexOf(" ");
                    while(pos != -1){
                        palabras++;
                        pos = line.indexOf(" ", pos + 1);
                    }
                    palabras++;
                }
            }

            System.out.println(palabras);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

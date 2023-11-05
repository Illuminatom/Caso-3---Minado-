    import java.util.Scanner;
    import java.io.UnsupportedEncodingException;
    import java.security.*;

    public class Main {
        public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Seleccione el algoritmo de Hashing a utilizar:");
                System.out.print(" (1. SHA-256");
                System.out.print(" - 2. SHA-512): ");
                int opcion = scanner.nextInt();

                String algoritmo = "SHA-256";
                if (opcion == 2) {
                    algoritmo = "SHA-512";
                }
                MessageDigest md = MessageDigest.getInstance(algoritmo);
                
                System.out.print("Ingrese el texto de entre 16 y 20 caracteres al cual aplicar el algoritmo: ");
                String mensajePlano = scanner.next();

                System.out.print("Ingrese la cantidad de 0's que debe tener el hash al inicio: ");
                int cantidadCeros = scanner.nextInt();

                byte[] hash = md.digest(mensajePlano.getBytes("UTF-8"));

                String repBinaria = "";
                for(byte b : hash) {
                    StringBuilder binaryStringBuilder = new StringBuilder(8);
                    for (int i = 0; i < 8; i++) {
                        if ((b & (1 << (7 - i))) == 0) {
                            binaryStringBuilder.append('0');
                        } else {
                            binaryStringBuilder.append('1');
                        }
                    }
                    repBinaria += binaryStringBuilder.toString();
                }
                    
                System.out.print("Seleccione la opcion de ejecucion");
                System.out.print(" (1. Monothread");
                System.out.print("- 2. Multithread): ");
                opcion = scanner.nextInt();

                if (opcion == 1) {
                    Monothread monoThread = new Monothread(cantidadCeros, mensajePlano, md, repBinaria);
      
                    monoThread.start();
                } else {
                    System.out.println("Aun no esta listo :P");
                }
            }

        }
    }

package lab6p1_jafethou;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class Lab6P1_JafetHou {
    
    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        int opcion = 0;
        boolean seguir = true;
        while (seguir) {
            
            opcion = Menu();
            
            switch (opcion) {
                
                case 1:{

                    System.out.println("Ingrese el tamano del arreglo a generar: ");
                    int num1 = leer.nextInt();
                    int [] tamano = new int [num1];
                    
                    while (num1 <= 1) {
                        System.out.println("El tamano debe ser mayor que 1. Inténtelo nuevamente.");
                        System.out.print("Ingrese el tamano del arreglo a generar: ");
                        num1 = leer.nextInt();
                    }
                    
                    System.out.println("Ingrese el limite inferior: ");
                    int num2 = leer.nextInt();
                    int [] inferior = new int [num2];
                    
                    System.out.println("Ingrese el limite superior: ");
                    int num3 = leer.nextInt();
                    int [] superior = new int [num3];
                    
                    while (num3 <= num2) {
                        System.out.println("El límite superior debe ser mayor que el límite inferior. Inténtelo nuevamente.");
                        System.out.print("Ingrese el límite superior: ");
                        num3 = leer.nextInt();
                    }
                    int[] randomArray = genRandArray(num1, num2, num3);
                    System.out.println("Arreglo generado: " + Arrays.toString(randomArray));

                    int[] primeCounts = getTotalPrimeCount(randomArray);
                    System.out.println("No. divisores primos: " + Arrays.toString(primeCounts));
                    
                    break;
                }
                case 2: {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Ingrese una palabra: ");
                    String palabra = scanner.nextLine().toLowerCase();

                    int[] frecuencias = extraerFrecuencias(palabra);

                    System.out.println("Frecuencias para la palabra: " + palabra);
                    imprimirFrecuencias(frecuencias);


                    break;
                }
                case 3: {
                    seguir = false;
                    break;
                }
                default: {
                    break;
                }

            }
            
        }
    }//fin del main
    
    public static int Menu(){
        
        int op = 0;
        System.out.println("1. Cuantos primos tienes?");
        System.out.println("2. Frecuencia de letras");
        System.out.println("3. Igrese [3] Para Salir]");
        System.out.println("Ingrese una opcion: ");

        op = leer.nextInt();

        return op;
    }
    public static int[] genRandArray(int tam, int inf, int sup) {
        int[] nom = new int[tam];
        Random random = new Random();

        for (int i = 0; i < tam; i++) {
            nom[i] = random.nextInt(sup - inf + 1) + inf;
        }

        return nom;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int countPrimeFactors(int num) {
        int cont = 0;

        for (int i = 2; i <= num; i++) {
            if (num % i == 0 && isPrime(i)) {
                cont++;
            }
        }

        return cont;
    }

    public static int[] getTotalPrimeCount(int[] nom){
        int[] prime = new int[nom.length];

        for (int i = 0; i < nom.length; i++) {
            prime[i] = countPrimeFactors(nom[i]);
        }

        return prime;
    }
    public static int[] extraerFrecuencias(String palabra) {
        int[] frecuencias = new int[27];

        for (char c : palabra.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                frecuencias[c - 'a']++;
            } else if (c == 65533) {
                frecuencias[27]++;
            }
        }

        return frecuencias;
    }

    public static void imprimirFrecuencias(int[] frecuencias) {
        char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z','0'};

        for (int i = 0; i < frecuencias.length; i++) {
            System.out.print("[" + frecuencias[i] + "]");
        }
        System.out.println();

        for (char letra : letras) {
            System.out.print("[" + letra + "]");
        }
        System.out.println();
    }
    

       

}


   
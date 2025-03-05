package javafxapplication1;

import java.util.Scanner;

public class cajero {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Variables y constantes
        final int PIN_CORRECTO = 4321;
        double saldo = 50000;
        int intentos = 0;
        boolean cuentaBloqueada = false;

        // Autenticación según intentos
        while (intentos < 3) {
            System.out.println("¡A ver, suéltame ese PIN!");
            int pinIngresado = scanner.nextInt();

            if (pinIngresado == PIN_CORRECTO) {
                System.out.println("¡Bienvenido a tu paraíso financiero, crack!");
                break;
            } else {
                intentos++;
                System.out.println("¡Ups! Eso no es el PIN, inténtalo de nuevo. ¡Vamos, tú puedes!");
            }

            if (intentos == 3) {
                cuentaBloqueada = true;
                System.out.println("¡Mera fregadera! Tres intentos fallidos, ¡tu cuenta está bloqueada!");
            }
        }

        // Si la cuenta está bloqueada, finaliza el programa
        if (cuentaBloqueada) {
            scanner.close();
            return;
        }

        // Menú del cajero
        int opcion;
        do {
            System.out.println("¡Bienvenido a tu cajero VIP, donde el dinero se respeta!");
            System.out.println("1. Consultar tu saldo jugoso");
            System.out.println("2. Sacar billete fresco");
            System.out.println("3. Ingresar más plata");
            System.out.println("4. Despedirse con estilo");
            System.out.println("¡Elige sabiamente, mi gente!");
            opcion = scanner.nextInt();

            // Manejo de opciones
            switch (opcion) {
                case 1:
                    System.out.println("Tienes en tu cuenta una cantidad impresionante: $ " + saldo);
                    break;

                case 2:
                    System.out.println("¿Cuánto de tu hermoso dinero vas a sacar?");
                    double retiro = scanner.nextDouble();
                    if (retiro > saldo || retiro <= 0) {
                        System.out.println("¡Eso es más de lo que tienes! Ojalá fuera tan fácil... Tienes: $ " + saldo);
                    } else {
                        saldo -= retiro;
                        System.out.println("¡Santo cielo, qué bien que sacaste paltica! Tu saldo actual es: " + saldo);
                    }
                    break;

                case 3:
                    System.out.println("¿Cuánto vas a inyectar en esta cuenta de lujo?");
                    double deposito = scanner.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("¡Dinero agregado con éxito! Tu cuenta ahora tiene: $ " + saldo);
                    } else {
                        System.out.println("¡Despierta, eso no sirve! Ingresa un valor positivo, ¿ok?");
                    }
                    break;

                case 4:
                    System.out.println("¡Adiós, buen amigo! Vuelve cuando quieras y que la plata te siga!");
                    break;

                default:
                    System.out.println("¿Qué estás haciendo, loco? Esa opción no existe. ¡Concentrate!");
                    break;
            }

        } while (opcion != 4);
        scanner.close();
    }
}

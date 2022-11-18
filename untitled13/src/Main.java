import javax.swing.*;

import java.io.*;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // write your code here|

        OpcionesClientes adminClientes = new OpcionesClientes();
        // menu
        int opcion = 0;
        int opcion2 = 0;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("opciones: ");
            System.out.println("1) Crear Cliente");
            System.out.println("2) Listar clientes");
            System.out.println("3) Buscar y listar datos completos de un cliente usando el Nombre");
            System.out.println("4) Buscar y listar datos completos de un cliente usando el DNI");
            System.out.println("5) Buscar y eliminar un cliente");
            System.out.println("6) Serializacion Y Deserializacion ");
            System.out.println("7) Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = leer.nextInt();
            //leer.nextLine();
            switch (opcion) {
                case 1:
                    //add Client
                    System.out.println("\n 1) Crear Cliente");
                    Cliente cliente = adminClientes.agregarCliente();
                    do {
                        System.out.println("Opciones: ");
                        System.out.println("1) Crear Cuenta");
                        System.out.println("2) Listar Cuentas");
                        System.out.println("3) Buscar y eliminar una Cuenta");
                        System.out.println("4) Monto de las cuentas segun su tipo");
                        System.out.println("5) Salir");
                        System.out.print("Ingrese una opcion: ");
                        opcion2 = leer.nextInt();
                        switch (opcion2) {
                            case 1:
                                cliente.agregarCuenta();
                                break;
                            case 2:
                                System.out.println("\n 2) Listar Cuentas\"");
                                cliente.mostrarNombredeCuenta();

                                break;
                            case 3:
                                System.out.println("\n 3) Buscar y eliminar una Cuenta");
                                cliente.eliminarCuenta();
                                break;
                            case 4:
                                System.out.println("\n 4) Monto de las cuentas segun su tipo");
                                cliente.MontoTotalPorCuenta();
                                break;
                            case 5:
                                System.out.println("\n 5) salir");
                                break;
                            default:
                                System.out.println("\n Opcion incorrecta");
                                break;
                        }
                    } while (opcion2 != 5);

                    break;
                case 2:
                    System.out.println("\n 2) Listar clientes");
                    adminClientes.listarClientes();

                    break;
                case 3:
                    System.out.println("\n 3) Buscar por nombre y listar datos completos del cliente");
                    adminClientes.buscarClientePorNombre();
                    break;
                case 4:
                    System.out.println("\n 4) Buscar por DNI y listar datos completos del cliente");
                    adminClientes.buscarClientePorDNI();
                    break;
                case 5:
                    System.out.println("\n 5) Buscar y eliminar un cliente");
                    adminClientes.eliminarCliente();
                    break;
                case 6:
                    System.out.println("\n 6) Serializacion Y Deserializacion ");
                    adminClientes.SerializacionYDeserializacion();
                    break;
                case 7:
                    System.out.println("\n 7) Salir");
                    break;
                default:
                    System.out.println("\n Opcion incorrecta");
                    break;
            }
        } while (opcion != 7);


    }
}

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

            //JOptionPane.showMessageDialog(null,"","Opciones",JOptionPane.INFORMATION_MESSAGE);

            opcion=Integer.parseInt(JOptionPane.showInputDialog(null,"1) Crear Cliente\n"
                    + "2) Listar clientes\n"
                    +"3) Buscar y listar datos completos de un cliente usando el Nombre\n"
                    +"4) Buscar y listar datos completos de un cliente usando el DNI\n"
                    +"5) Buscar y eliminar un cliente\n"
                    +"6) Serializacion Y Deserializacion\n"
                    +"7) Salir","Opciones",JOptionPane.INFORMATION_MESSAGE));


            //leer.nextLine();
            switch (opcion) {
                case 1:
                    //add Client
                    System.out.println("\n 1) Crear Cliente");
                    Cliente cliente = adminClientes.agregarCliente();
                    do {
                        opcion2=Integer.parseInt(JOptionPane.showInputDialog(null,"1) Crear Cuenta\n"
                                + "2) Listar Cuentas\n"
                                + "3)Buscar y mostrar datos de una cuenta\n"
                                +"4) Buscar y eliminar una Cuenta\n"
                                +"5) Monto de las cuentas segun su tipo\n"
                                +"6) Salir","Opciones",JOptionPane.INFORMATION_MESSAGE));

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
                                cliente.buscarCuentaPorNombre();
                                break;
                            case 4:
                                System.out.println("\n 3) Buscar y eliminar una Cuenta");
                                cliente.eliminarCuenta();
                                break;
                            case 5:
                                System.out.println("\n 4) Monto de las cuentas segun su tipo");
                                cliente.MontoTotalPorCuenta();
                                break;
                            case 6:
                                System.out.println("\n 5) salir");
                                break;
                            default:
                                System.out.println("\n Opcion incorrecta");
                                break;
                        }
                    } while (opcion2 != 6);

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

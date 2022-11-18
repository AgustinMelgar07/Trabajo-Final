import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class OpcionesClientes implements Serializable {
    private LinkedList<Cliente> clientes;

    public OpcionesClientes() {
        this.clientes = new LinkedList<>();
    }

    String nombres;
    int dnis;

    public Cliente agregarCliente() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese Nombre: ");
        String nombre = leer.nextLine();

        System.out.print("Ingrese DNI:");
        int dni = leer.nextInt();

        Cliente cliente = new Cliente(nombre, dni);
        nombres = cliente.getNombre();
        dnis = cliente.getDni();
        this.clientes.add(cliente);

        return cliente;
    }

    public void listarClientes() throws FileNotFoundException, IOException, ClassNotFoundException {
        for (Cliente cliente1 : clientes) {
            System.out.println(cliente1.MostrarDatos());
        }

    }

    public void buscarClientePorNombre() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el Nombre del cliente que quiera buscar: ");
        String nombreCliente = leer.nextLine();
        for (Cliente cliente1 : clientes) {
            if (cliente1.getNombre().equals(nombreCliente)) {
                System.out.println(cliente1.MostrarDatos());
            }
        }
    }

    public void buscarClientePorDNI() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el DNI del cliente que quiera buscar: ");
        int nombreCliente = leer.nextInt();
        for (Cliente cliente1 : clientes) {
            if (cliente1.getDni()==nombreCliente) {
                System.out.println(cliente1.MostrarDatos());
            }
        }
    }
    public void eliminarCliente() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el Nombre del cliente que quiera eliminar: ");
        String nombreCliente1 = leer.nextLine();
        for (Cliente cliente1 : clientes) {
            if (cliente1.getNombre().equals(nombreCliente1)) {
                clientes.remove(cliente1);
                System.out.println("Cliente eliminado");
                break;
            }
        }
    }

    public void SerializacionYDeserializacion() {
        for (Cliente cliente1 : clientes) {
            //System.out.println(cliente1.MostrarDatos());

            try {
                FileWriter crearficherodenombres = new FileWriter("C:\\Users\\AMD Ryzen\\untitled13\\miObjetoSerializado.txt", true);

                for (int i = 0; i < cliente1.MostrarDatos().length(); i++) {
                    crearficherodenombres.write(cliente1.MostrarDatos().charAt(i));
                }
                crearficherodenombres.write("\n");
                crearficherodenombres.close();
            } catch (IOException a) {
                a.printStackTrace();
            }
        }
        ;

        try {
            FileReader archivo;
            BufferedReader lector;
            archivo = new FileReader("C:\\Users\\AMD Ryzen\\untitled13\\miObjetoSerializado.txt");
            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;
                while ((cadena = lector.readLine())!=null) {
                    System.out.println(cadena);
                }
            }else{
                System.out.println("el archivo no esta listo para ser leido...");
            }

        }catch (Exception ex) {
            System.out.println("error"+ex.getMessage());
        } ;


    }
}

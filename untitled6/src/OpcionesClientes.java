import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class OpcionesClientes implements Serializable {
    private LinkedList<Cliente> clientes;

    public OpcionesClientes() {
        this.clientes = new LinkedList<>();
    }


    public Cliente agregarCliente() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese Nombre: ");
        String nombre = JOptionPane.showInputDialog(null,"Nombre: ","Ingreso del Nombre",JOptionPane.INFORMATION_MESSAGE);
        System.out.print("Ingrese DNI:");
        int dni =Integer.parseInt(JOptionPane.showInputDialog(null,"DNI: ","Ingreso del DNI",JOptionPane.INFORMATION_MESSAGE));
        Cliente cliente = new Cliente(nombre, dni);
        this.clientes.add(cliente);

        return cliente;
    }

    public void listarClientes(){
        for (Cliente cliente1 : clientes) {
            System.out.println(cliente1.toString());
            JOptionPane.showMessageDialog(null,cliente1.toString(),"Opciones",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void buscarClientePorNombre() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el Nombre del cliente que quiera buscar: ");
        String nombreCliente = JOptionPane.showInputDialog(null,"Ingrese el Nombre del cliente que quiera buscar: ",
                "Busqueda de cliente por nombre",JOptionPane.INFORMATION_MESSAGE);
        for (Cliente cliente1 : clientes) {
            if (cliente1.getNombre().equals(nombreCliente)) {
                System.out.println(cliente1.toString());
                JOptionPane.showMessageDialog(null,cliente1.toString(),"Opciones",JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    public void buscarClientePorDNI() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el DNI del cliente que quiera buscar: ");
        int DNIaBUSCAR =Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el DNI del cliente que quiera buscar: ",
                "Busqueda de cliente por DNI",JOptionPane.INFORMATION_MESSAGE));
        for (Cliente cliente1 : clientes) {
            if (cliente1.getDni()==DNIaBUSCAR) {
                System.out.println(cliente1.toString());
                JOptionPane.showMessageDialog(null,cliente1.toString(),"Opciones",JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }
    public void eliminarCliente() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el Nombre del cliente que quiera eliminar: ");
        String nombreCliente1 = JOptionPane.showInputDialog(null,"Ingrese el Nombre del cliente que quiera eliminar: ",
                "Busqueda de cliente por nombre para eliminar",JOptionPane.INFORMATION_MESSAGE);
        for (Cliente cliente1 : clientes) {
            if (cliente1.getNombre().equals(nombreCliente1)) {
                clientes.remove(cliente1);
                System.out.println("Cliente eliminado");
                JOptionPane.showMessageDialog(null,"Cliente Eliminado","Opciones",JOptionPane.INFORMATION_MESSAGE);

                break;
            }
        }
    }

    public void SerializacionYDeserializacion() {
        for (Cliente cliente1 : clientes) {
            //System.out.println(cliente1.toString());

            try {
                FileWriter crearficherodenombres = new FileWriter("C:\\Users\\Usuario\\untitled6\\miObjetoSerializado.txt", true);

                for (int i = 0; i < cliente1.toString().length(); i++) {
                    crearficherodenombres.write(cliente1.toString().charAt(i));
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
            archivo = new FileReader("C:\\Users\\Usuario\\untitled6\\miObjetoSerializado.txt");
            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;
                while ((cadena = lector.readLine())!=null) {
                    System.out.println(cadena);
                    JOptionPane.showMessageDialog(null,cadena,"error",JOptionPane.INFORMATION_MESSAGE);

                }
            }else{
                System.out.println("el archivo no esta listo para ser leido...");
                JOptionPane.showMessageDialog(null,"el archivo no esta listo para ser leido...","archivo no listo",JOptionPane.INFORMATION_MESSAGE);

            }

        }catch (Exception ex) {
            System.out.println("error"+ex.getMessage());
            JOptionPane.showMessageDialog(null,"error"+ex.getMessage(),"error",JOptionPane.INFORMATION_MESSAGE);

        } ;


    }
}
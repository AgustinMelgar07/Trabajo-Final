import javax.swing.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class Cliente implements Serializable {
    private String nombre;
    private int dni;
    private LinkedList<Cuenta> cuentas;
    public Cliente(String nombre, int dni) {
        this.nombre=nombre;
        this.dni=dni;
        this.cuentas = new LinkedList<>();
    }

    String nombreCuenta;

    public void agregarCuenta(){
        Scanner leer2 = new Scanner(System.in);
        System.out.println("\n 1) Crear Cuenta");
        System.out.print("NOMBRE: ");
        String nombre = JOptionPane.showInputDialog(null,"Nombre: ","Ingreso del Nombre",JOptionPane.INFORMATION_MESSAGE);
        nombreCuenta=nombre;
        System.out.print("TIPO: ");
        String tipo = JOptionPane.showInputDialog(null,"Tipo: ","Ingreso del Nombre",JOptionPane.INFORMATION_MESSAGE);
        System.out.print("MONTO:");
        int monto =Integer.parseInt(JOptionPane.showInputDialog(null,"Monto: ","Ingreso del DNI",JOptionPane.INFORMATION_MESSAGE));
        Cuenta cuenta= new Cuenta(nombre, tipo ,monto);
        this.cuentas.add(cuenta);
    }


    public void mostrarNombredeCuenta(){
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.toString());
            JOptionPane.showMessageDialog(null,cuenta.toString(),"Opciones",JOptionPane.INFORMATION_MESSAGE);

        }
    }
    public void buscarCuentaPorNombre() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el Nombre de la Cuenta que quiera buscar: ");
        String nombreCliente = JOptionPane.showInputDialog(null,"Ingrese el Nombre de la Cuenta que quiera buscar: ",
                "Busqueda de Cuenta por nombre",JOptionPane.INFORMATION_MESSAGE);
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNombre().equals(nombreCliente)) {
                System.out.println(cuenta.toString());
                JOptionPane.showMessageDialog(null,cuenta.toString(),"Opciones",JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    public void eliminarCuenta() {
        Scanner leer = new Scanner(System.in);
        System.out.print("NOMBRE: ");
        String nombreCliente1 = JOptionPane.showInputDialog(null,"Ingrese el Nombre del cliente que quiera eliminar: ",
                "Busqueda de cliente por nombre para eliminar",JOptionPane.INFORMATION_MESSAGE);
        for (Cuenta cuenta : cuentas)  {
            if (cuenta.getNombre().equals(nombreCliente1)) {
                cuentas.remove(cuenta);
                System.out.println("Cuenta eliminada");
                JOptionPane.showMessageDialog(null,"Cliente Eliminado","Opciones",JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }

    public void MontoTotalPorCuenta() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Tipo de cuenta que desea saber su monto: ");
        String tipo = JOptionPane.showInputDialog(null,"Ingrese el tipo de cuenta que quiera saber su monto total: ","Monto total por tipo",JOptionPane.INFORMATION_MESSAGE);
        double monto=0;

        for (Cuenta cuenta : cuentas) {
            if (cuenta.getTipo().equals(tipo)) {
                monto = monto+cuenta.getMonto();
            }
        }
        System.out.println(monto);
        JOptionPane.showMessageDialog(null, tipo+"= "+monto,"Monto Total:",JOptionPane.INFORMATION_MESSAGE);


    }
    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    @Override
    public String toString(){

        StringBuilder builder = new StringBuilder();

        builder.append("Cliente{" +
                "Nombre: " + getNombre() +
                ", DNI: " + getDni() +
                ", Activos: " + this.cuentas + "}");


        return builder.toString();


    }

}
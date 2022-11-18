
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class Cliente implements Datos, Serializable {
    private String nombre;
    private int dni;
    private LinkedList<Cuenta> cuentas;
    public Cliente(String nombre, int dni) {
        this.nombre=nombre;
        this.dni=dni;
        this.cuentas = new LinkedList<>();
    }

    String nombreCuenta;

    //add Activo to the colection
    public void agregarCuenta(){
        Scanner leer2 = new Scanner(System.in);
        System.out.println("\n 1) Crear Cuenta");
        System.out.print("NOMBRE: ");
        String nombre = leer2.nextLine();
        nombreCuenta=nombre;
        System.out.print("TIPO: ");
        String tipo = leer2.nextLine();
        System.out.print("MONTO:");
        double monto = leer2.nextDouble();
        Cuenta cuenta= new Cuenta(nombre, tipo ,monto);
        this.cuentas.add(cuenta);
    }

    //search activos by name
    public void mostrarNombredeCuenta(){
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.toString());

        }
    }

    public void eliminarCuenta() {
        Scanner leer = new Scanner(System.in);
        System.out.print("NOMBRE: ");
        String nombreCliente1 = leer.nextLine();
        for (Cuenta cuenta : cuentas)  {
            if (cuenta.getNombre().equals(nombreCliente1)) {
                cuentas.remove(cuenta);
                System.out.println("Cuenta eliminada");
                break;
            }
        }
    }

    public void MontoTotalPorCuenta() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Tipo de cuenta que desea saber su monto: ");
        String tipo = leer.nextLine();
        double monto=0;

        for (Cuenta cuenta : cuentas) {
            if (cuenta.getTipo().equals(tipo)) {
                monto = monto+cuenta.getMonto();
            }
        }
        System.out.println(monto);

    }
    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    @Override
    public String MostrarDatos() {

        StringBuilder builder = new StringBuilder();

        builder.append("Cliente{" +
                "Nombre: " + getNombre() +
                ", DNI: " + getDni() +
                ", Activos: " + this.cuentas +
                '}');


        return builder.toString();


    }

}
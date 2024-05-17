// Cine.java
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class Cine {
    private Queue<Asistente> colaAsistentes;
    private int capacidad = 23; // Capacidad de la sala de cine
    private int entradasVendidas = 0; // Cantidad de entradas vendidas

    public Cine(){
        // inicialice el objeto
        colaAsistentes = new LinkedList<>();
    }

    public boolean esVacia(){
        // cambie el método para que funcione correctamente
        return colaAsistentes.isEmpty();
    }

    public int tamanio(){
        // actualice la sentencia para que devuelva el tamaño de elementos en la cola
        return colaAsistentes.size();
    }

    public void encolar(Asistente asistente){
        // complete el método
        if (asistente.getCantidad() <= 3 && entradasVendidas + asistente.getCantidad() <= capacidad) {
            colaAsistentes.add(asistente);
            entradasVendidas += asistente.getCantidad();
        } else {
            System.out.println("No se pueden vender más entradas de las disponibles.");
        }
    }

    public Object desencolar() {
        // actualice el método para eliminar el elemento del inicio.
        return colaAsistentes.poll();
    }

    // cree un método para listar los elementos en una textArea.
    public void listarAsistentes(JTextArea textArea) {
        for (Asistente asistente : colaAsistentes) {
            textArea.append(asistente.toString() + "\n");
        }
    }

    // cree un método para conocer la cantidad de entradas disponibles
    public int entradasDisponibles() {
        return capacidad - entradasVendidas;
    }
}

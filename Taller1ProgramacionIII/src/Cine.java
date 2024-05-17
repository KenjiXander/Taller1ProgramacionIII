import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
//En el diseño del Formulario existe un label actualice a su Nombre y Apellido
//No borre ninguna sección del codigo proporcionado,
// Si borra tendrá la nota minima 1.0
//Se necesita completar las clases Cine y Formulario
//Con los algoritmos y métodos necesarios de la estructura FIFO
//Enunciado: Cada sala de cine tiene una capacidad de 23 espacios, solo se
//pueden comprar como máximo 3 entradas por cliente a una pelicula, VALIDAR Y GARANTIZAR QUE NO SE PUEDAN VENDER MÁS VOLETOS DE LOS DISPONIBLES
//Desplegar cada una de las compras en el textArea.
//Se necesita consultar cuántos espacios quedan disponibles por cada una
//de las peliculas. DESPLEGAR DESPUES DE CADA COMPRA
//Rubrica de calificación:
//Completar la clase Cine 4 Puntos.
//Agregar elemento a la Cola y mostrar en el textArea 2 Puntos.
//Programar los botones para conocer la cantidad de espacios disponibles 4 Puntos.
//Suba su programa a la plataforma hasta que finalice la hora.

public class Cine {
    //Declare la referencia Cola para almacenar asistentes
    private Queue<Asistente> colaAsistentes;
    private int capacidad = 23; // Capacidad de la sala de cine
    private int entradasVendidas = 0; // Cantidad de entradas vendidas

    public Cine(){
        colaAsistentes = new LinkedList<>();
    }

    public boolean esVacia(){
        return colaAsistentes.isEmpty();
    }

    public int tamanio(){
        return colaAsistentes.size();
    }

    public void encolar(Asistente asistente){
        if (asistente.getCantidad() <= 3 && entradasVendidas + asistente.getCantidad() <= capacidad) {
            colaAsistentes.add(asistente);
            entradasVendidas += asistente.getCantidad();
        } else {
            System.out.println("No se pueden vender más entradas de las disponibles.");
        }
    }

    public Object desencolar() {
        return colaAsistentes.poll();
    }

    public void listarAsistentes(JTextArea textArea) {
        for (Asistente asistente : colaAsistentes) {
            textArea.append(asistente.toString() + "\n");
        }
    }

    public int entradasDisponibles() {
        return capacidad - entradasVendidas;
    }
}

import java.util.ArrayList;
import java.util.Collections;

public class Baraja<T> {
    private ArrayList<T> cartas;
    private ArrayList<T> cartasRepartidas;

    public Baraja(){
        this.cartas = new ArrayList<>();
        this.cartasRepartidas = new ArrayList<>(); //Lista donde estan las cartas que ya se repartieron
    }

    //Mezcla las cartas
    public void barajar(){
        // Se devuelven al mazo todas las cartas usadas previamente
        cartas.addAll(cartasRepartidas);
        // Se vacia la lista de repartidas
        cartasRepartidas.clear();
        // Se mezclan todas las cartas aleatoriamente
        Collections.shuffle(cartas);
    }

    //Devuelve la siguiente carta disponible
    private T obtenerSiguiente(){
        if (cartas.isEmpty()) {
            return null; // En caso de no haber más cartas en el mazo, retorna null
        }
        return cartas.remove(0); // Saca la carta de arriba (posición 0) y la devuelve
    }

    //Devuelve la cantidad de cartas
    public int cantidadDisponible(){
        return cartas.size();
    }

    //Devuelve una lista con cierta cantidad de cartas
    public ArrayList<T> repartir(int cantidad){
        ArrayList<T> cartasARepartir = new ArrayList<>(); //Creo una lista con las cartas que voy a repartir
        for (int i = 1; i <= cantidad; i++) { //Itero en base a la cantidad de cartas que quiero repartir
            T siguiente = obtenerSiguiente();
            if (siguiente != null){ //Si todavia no se acaban las cartas sigo repartiendo
                cartasARepartir.add(siguiente);
            }else { //Si se acaban devuelvo null para indicar que no se pudieron repartir
                System.out.println("Ya no quedan cartas suficientes");
                cartas.addAll(cartasARepartir);
                return null; //Esto hace que si solo quedan por ejemplo 2 cartas para repartir pero yo queria repartir 4 me devuelva null
            }
        }
        cartasRepartidas.addAll(cartasARepartir); //Pongo los elementos de cartasARepartir en cartasRepartidas
        return cartasARepartir;
    }

    //Muestra las cartas repartidas
    public void mostrarRepartidas(){
        if (cartasRepartidas.isEmpty()) { // Compruebo que hayan cartas repartidas
            System.out.println("No hay cartas repartidas"); // En el caso de que la lista esté vacia, solo imprimimos un mensaje por consola
        }else{ // En el caso de que hayan cartas repartidas, hacemos un for each y mostramos cada carta de manera individual
            System.out.println("Se han repartido las siguientes cartas: ");
            for (T repartida : cartasRepartidas) {
                System.out.println(repartida);
            }
        }
    }

    //Muestra las cartas que no han sido repartidas
    public void mostrarDisponibles(){
        if (cartas.isEmpty()) {
            System.out.println("No hay cartas disponibles ");
        }else{
            System.out.println("Las siguientes cartas no han sido repartidas: ");
            for (T carta : cartas) {
                System.out.println(carta);
            }
        }
    }//Se sigue la misma logica que en el método mostrarRepartidas

    //Agrega una carta al mazo
    public void agregarCarta(T carta){
        cartas.add(carta);
    }

    //Quita una carta del mazo
    public void quitarCarta(T carta){
        cartas.remove(carta);
    }
}

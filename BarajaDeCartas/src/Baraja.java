import java.util.ArrayList;

public class Baraja<T> {
    private ArrayList<T> cartas;
    private ArrayList<T> cartasRepartidas;

    public Baraja(){
        this.cartas = new ArrayList<>();
        this.cartasRepartidas = new ArrayList<>(); //Lista donde estan las cartas que ya se repartieron
    }

    public void barajar(){
        cartasRepartidas.clear(); //Cada vez que barajo reinicio las cartas repartidas
        //Cuando barajo tambien hay que implementar un reseteo en obtener siguiente
    } //Mescla las cartas

    public T obtenerSiguiente(){
        return null; //Es necesario que devuelva null en caso de que ya no queden mas cartas
    } //Devuelve la siguiente carta disponible

    public int cantidadDisponible(){
        return cartas.size();
    } //Devuelve la cantidad de cartas

    public ArrayList<T> repartir(int cantidad){
        ArrayList<T> cartasARepartir = new ArrayList<>(); //Creo una lista con las cartas que voy a repartir
        for (int i = 1; i <= cantidad; i++) { //Itero en base a la cantidad de cartas que quiero repartir
            T siguiente = obtenerSiguiente();
            if (siguiente != null){ //Si todavia no se acaban las cartas sigo repartiendo
                cartasARepartir.add(siguiente);
            }else { //Si se acaban devuelvo null para indicar que no se pudieron repartir
                System.out.println("Ya no quedan cartas suficientes");
                return null; //Esto hace que si solo quedan por ejemplo 2 cartas para repartir pero yo queria repartir 4 me devuelva null
            }
        }
        cartasRepartidas.addAll(cartasARepartir); //Pongo los elementos de cartasARepartir en cartasRepartidas
        return cartasARepartir;
    } //Devuelve una lista con cierta cantidad de cartas

    public void mostrarRepartidas(){
        if (cartasRepartidas.isEmpty()) { // Compruebo que hayan cartas repartidas 
            System.out.println("No hay cartas repartidas"); // En el caso de que la lista esté vacia, solo imprimimos un mensaje por consola
        }else{ // En el caso de que hayan cartas repartidas, hacemos un for each y mostramos cada carta de manera individual
            System.out.println("Se han repartido las siguientes cartas: ");
            for (T repartida : cartasRepartidas) {
                System.out.println(repartida);
            }
        }
        
    } //Muestra las cartas repartidas
    
    
    //Se sigue la mmisma logica que en la anterior
    public void mostrarDisponibles(){
        if (cartas.isEmpty()) {
            System.out.println("No hay cartas disponibles ");
        }else{
            System.out.println("Las siguientes cartas no han sido repartidas: ");
            for (T carta : cartas) {
                System.out.println(carta);
            }
        }
    } //Muestra las cartas que no han sido repartidas

    public void agregarCarta(T carta){
        cartas.add(carta);
    } //Agrega una carta al mazo

    public void quitarCarta(T carta){

    } //Quita una carta del mazo

    
    
    
}

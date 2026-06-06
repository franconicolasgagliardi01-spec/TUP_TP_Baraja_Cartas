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
            if (obtenerSiguiente() != null){ //Si todavia no se acaban las cartas sigo repartiendo
                cartasARepartir.add(obtenerSiguiente());
            }else { //Si se acaban devuelvo null para indicar que no se pudieron repartir
                System.out.println("Ya no quedan cartas suficientes");
                return null; //Esto hace que si solo quedan por ejemplo 2 cartas para repartir pero yo queria repartir 4 me devuelva null
            }
        }
        cartasRepartidas.addAll(cartasARepartir); //Pongo los elementos de cartasARepartir en cartasRepartidas
        return cartasARepartir;
    } //Devuelve una lista con cierta cantidad de cartas

    public void mostrarRepartidas(){

    } //Muestra las cartas repartidas

    public void mostrarDisponibles(){

    } //Muestra las cartas que no han sido repartidas

    public void agregarCarta(T carta){
        cartas.add(carta);
    } //Agrega una carta al mazo

    public void quitarCarta(T carta){

    } //Quita una carta del mazo




}

package TestAlien;

import Alien.Alien;

public class TestConstructores {

    public static void main(String[] args) {

    	Alien alien1 = new Alien(10, "Verde");
        alien1.imprimir();

        Alien alien2 = new Alien(2, "Azul");
        alien2.imprimir();


        Alien alien3 = new Alien(50, "Rojo");
        alien3.imprimir();
    }
    
}
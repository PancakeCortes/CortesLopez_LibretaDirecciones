package Adress;

import Adress.data.AdressBook;


/**
 * Esta es la clase encarga de instanciar la única instancia de la libreta de direcciones siguiendo
 * el patrón de arquitectura singleton, a partir de esta clase también se llama a la clase menú para
 * permitir al usuario interactuar con el programa
 */
public class AdressBookAplication {
    public static void main(String[] args) {
        AdressBook newAdressBook = new AdressBook();
        Menu newMenu = new Menu(newAdressBook);
        newMenu.displayMenu();

    }
}
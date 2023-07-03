package Adress;

/**
 * Dentro de este bloque  sew importan todas las librerías necesarias para el funcionamiento
 * del programa así como las dependecias correspondientes relacionadas con las otras partes
 * del programa
 */

import java.util.Scanner;
import java.io.IOException;
import Adress.data.AdressBook;
import Adress.data.AdressEntry;



/**
 * En esta sección se instancia una nueva libreta de direcciones
 */

public class Menu {
    private AdressBook newAdressBook;
    private Scanner reader;

    public Menu(AdressBook newAdressBook) {
        this.newAdressBook = newAdressBook;
        reader = new Scanner(System.in);
    }


    /**
     * En el siguiente bloque se encuentra el metodo que permite al sistema realizar la comprobación
     * de que el usuario realizo una selección correcta de entre las opciones que se le presentaron y
     * no sale de ese rango, también se establece una variable booleana que se utilizará más tarde
     * para controlar el fin de la ejecución de la aplicación
     */
    public void displayMenu() {
        int optionSelector = 0;
        int minOption = 1;
        int maxOption = 6;
        boolean optionComprobation = false;
        boolean exitApplication = false;


        /**
         * Dentro de este ciclo while se establece que mientras la variable booleana sea falsa el sistema seguirá
         * mostrando las opciones al usuario al terminar cada operación
         */

        while (!exitApplication) {
            System.out.println(" ▀▄▀▄▀▄⚜Menu⚜▄▀▄▀▄▀\n\n\n");
            System.out.println("ヽ(*・ω・)ﾉ\n");
            System.out.println(" ¿Qué puedo hacer por usted hoy?\n\n");
            System.out.println("[1] Cargar registros de archivo existente");
            System.out.println("[2] Registrar entrada");
            System.out.println("[3] Eliminar entrada");
            System.out.println("[4] Buscar por apellido");
            System.out.println("[5] Mostrar todas las entradas");
            System.out.println("[6] Cerrar\n\n");

            /**
             * En este bloque se realiza la comprobación de que efectivamente el usuario selecciono un número
             * entero validon como una de las opciones a realizar, utilizando un objeto reader para obtener
             * entrada por parte del usuario
             */
            do {
                try {
                    System.out.print("\n\nIngrese el número de la opción deseada: ");
                    optionSelector = reader.nextInt();
                    optionComprobation = true;
                    if (optionSelector < minOption || optionSelector > maxOption) {
                        System.out.println("\n\nPor favor ingrese una de las 6 opciones mostradas ");
                        optionComprobation = false;
                    }
                } catch (Exception e) {
                    System.out.println("\n\nError, debe ingresar un número entero entre " + minOption + " y " + maxOption);
                    optionComprobation = false;
                    reader.next();
                }
            } while (!optionComprobation);

            reader.nextLine();

            /**
            *  Dentro del siguiente Switch se establecen las diferentes funciones que el sistema va  a ofrecer al usuario, así cómo
            *  las respectivas excepciones y errores que el sistema arrojará en caso de que el usuario ingrese un dato inválido, y
             * los valores que cada opción debería devolver si fuera el caso
             */
            switch (optionSelector) {
                case 1:
                    System.out.print("\n\nIngrese la ruta del archivo: ");
                    String filePath = reader.nextLine();

                    if (!validateString(filePath)) {
                        System.out.println("Error\n\n Se deben de llenar todos los campos\n＼(º □ º l|l)\n");
                        break;
                    }

                    try {
                        newAdressBook.readEntries(filePath);
                        System.out.println("\n\nSe han cargado las entradas del archivo\nヽ(*・ω・)ﾉ\n");
                    } catch (IOException e) {
                        System.out.println("\n\nError\n\n Ruta de archivo no válida\n＼(º □ º l|l)\n");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre: ");
                    String firstName = reader.nextLine();
                    if (!validateString(firstName)) {
                        System.out.println("\n\nError\n\n Se deben de llenar todos los campos\n＼(º □ º l|l)\n");
                        break;
                    }

                    System.out.print("Ingrese el apellido: ");
                    String lastName = reader.nextLine();
                    if (!validateString(lastName)) {
                        System.out.println("\n\nError\n\n Se deben de llenar todos los campos\n＼(º □ º l|l)\n");
                        break;
                    }

                    System.out.print("Ingrese el estado: ");
                    String state = reader.nextLine();
                    if (!validateString(state)) {
                        System.out.println("\n\nError\n\n Se deben de llenar todos los campos\n＼(º □ º l|l)\n");
                        break;
                    }

                    System.out.print("Ingrese la ciudad: ");
                    String city = reader.nextLine();
                    if (!validateString(city)) {
                        System.out.println("\n\nError\n\n Se deben de llenar todos los campos\n＼(º □ º l|l)\n");
                        break;
                    }

                    System.out.print("Ingrese la calle: ");
                    String street = reader.nextLine();
                    if (!validateString(street)) {
                        System.out.println("\n\nError\n\n Se deben de llenar todos los campos\n＼(º □ º l|l)\n");
                        break;
                    }

                    System.out.print("Ingrese el código postal: ");
                    String cp = reader.nextLine();
                    if (!validateString(cp)) {
                        System.out.println("\n\nError\n\n Se deben de llenar todos los campos\n＼(º □ º l|l)\n");
                        break;
                    }

                    System.out.print("Ingrese el número de teléfono: ");
                    String phone = reader.nextLine();
                    if (!validateString(phone)) {
                        System.out.println("\n\nError\n\n Se deben de llenar todos los campos\n＼(º □ º l|l)\n");
                        break;
                    }

                    System.out.print("Ingrese el correo electrónico: ");
                    String email = reader.nextLine();
                    if (!validateString(email)) {
                        System.out.println("\n\nError\n\n Se deben de llenar todos los campos\n＼(º □ º l|l)\n");
                        break;
                    }

                    AdressEntry newEntry = new AdressEntry(firstName, lastName, street, city, state, cp, phone, email);

                    newAdressBook.addEntry(newEntry);
                    System.out.println("\n\nLa entrada se ha registrado exitosamente\nヽ(*・ω・)ﾉ\n");
                    break;

                case 3:
                    System.out.print("Ingrese el apellido de la entrada a eliminar: ");
                    String lastNameToDelete = reader.nextLine();
                    if (!validateString(lastNameToDelete)) {
                        System.out.println("\n\nError\n\n Se deben de llenar todos los campos\n＼(º □ º l|l)\n");
                        break;
                    }
                    AdressEntry entryToDelete = searchEntry(lastNameToDelete);
                    if (entryToDelete != null) {
                        newAdressBook.removeEntry(entryToDelete);
                        System.out.println("\n\nLa entrada se eliminó exitosamente\nヽ(*・ω・)ﾉ\n");
                    } else {
                        System.out.println("\n\nNo se encontraron coincidencias\n＼(º □ º l|l)\n");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el apellido a buscar: ");
                    String lastNameToSearch = reader.nextLine();
                    if (!validateString(lastNameToSearch)) {
                        System.out.println("\n\nError\n\n Se deben de llenar todos los campos\n＼(º □ º l|l)\n");
                        break;
                    }
                    AdressEntry foundEntry = searchEntry(lastNameToSearch);
                    if (foundEntry != null) {
                        System.out.println("\n\nEntrada encontrada\nヽ(*・ω・)ﾉ\n");
                        System.out.println(foundEntry);
                    } else {
                        System.out.println("\n\nNo se encontraron coincidencias\n＼(º □ º l|l)\n");
                    }
                    break;
                case 5:
                    System.out.println("\n\n▀▄▀▄▀▄⚜Entradas⚜▄▀▄▀▄▀\n");
                    for (AdressEntry entryList : newAdressBook.displayEntries()) {
                        System.out.println(entryList);
                    }
                    break;
                case 6:
                    exitApplication = true;
                    System.out.println("\n\n\n\n▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄");
                    System.out.println("\n\nGracias por cerrarme, dejen mimir\n\n(=⌒‿‿⌒=)");
                    break;
            }
        }

        System.out.println();
        reader.close();
    }

    private AdressEntry searchEntry(String lastName) {
        for (AdressEntry foundEntry : newAdressBook.displayEntries()) {
            if (foundEntry.getLastName().equalsIgnoreCase(lastName)) {
                return foundEntry;
            }
        }
        return null;
    }

    /**
     * Dentro de este bloque se declará la variable validateString cómo booleana que se usa en el proceso de comprobación
     * para ver si el campo dado por el usuario se encuentra vació
     * @param stringState booleano de compbración
     * @return
     */
    private boolean validateString(String stringState) {
        return !stringState.trim().isEmpty();
    }

}


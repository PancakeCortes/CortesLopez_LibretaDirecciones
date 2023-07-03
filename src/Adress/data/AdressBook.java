package Adress.data;
/**
 * Aquí se importan las liberias necesarias para el correcto funcionamiento del programa
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class AdressBook {
    /**
     * En esta sección se establece la estructura de lista que se usará para recopilar
     * y organizar los datos recabados de las entradas, esto debido a su eficiencia
     * y fácil uso
     */
    private List<AdressEntry> userEntries;

    public AdressBook() {
        userEntries = new ArrayList<>();
    }


    /**
     * Aquí se establece el método para que el programa pueda registrar y guardar nuevas entradas
     *
     * @param newEntry El conjunto de datos que el usuario registrará y será guardado como arreglo
     * */

    public void addEntry(AdressEntry newEntry) {
        userEntries.add(newEntry);
    }

    /**
     * Este método sirve para borrar la entrada especificada por el usuario
     *
     * @param newEntry El conjunto de datos en array que el usuario va a eliminar según su búsqueda
     */
    public void removeEntry(AdressEntry newEntry) {
        userEntries.remove(newEntry);
    }

    /**
     * Este método utiliza las librerias Collecrtions y Comparator para poder ordenar las entradas en base al orden
     * alfabetico del apellido de los usuarios
     *
     * @return devuelve las entradas ordenadas en orden alfabetico
     */

    public List<AdressEntry> displayEntries() {
        List<AdressEntry> sortedEntries = new ArrayList<>(userEntries);
        Collections.sort(sortedEntries, Comparator.comparing(AdressEntry::getLastName));
        return sortedEntries;
    }

    /**
     * Aquí se empiezan con los métodos para leer entradas de archivos externos
     * Esta es la excepción para tratar de buscar un archivo inexistente
     *
     * @param filePath la ruta del archivo a buscar
     * @throws IOException excepción indicando al usuario que proporciono una ruta incorrecta
     */
    public void readEntries(String filePath) throws IOException {
        File newFile = new File(filePath);
        if (!newFile.exists()) {
            throw new IOException("Ruta de archivo incorrecta");
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(newFile))) {
            String newLine;
            int dataLengthLimit = 8;
            while ((newLine = reader.readLine()) != null) {
                String[] entryData = newLine.split(",");
                if (entryData.length == dataLengthLimit) {
                    AdressEntry newAddressEntry = new AdressEntry(
                            entryData[1].trim(),
                            entryData[2].trim(),
                            entryData[3].trim(),
                            entryData[4].trim(),
                            entryData[5].trim(),
                            entryData[6].trim(),
                            entryData[7].trim(),
                            entryData[8].trim()
                    );

                    userEntries.add(newAddressEntry);

                }
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Este método busca las entradas basando en el apellido de la entrada a buscar
     * @param lastName es el apellido de la entrada en cuestión
     * @return retorna las entradas que correspondan al parámetro de apellido dado pon el usuario
     */

    public List<AdressEntry> searchEntry(String lastName) {
        List<AdressEntry> foundEntry = new ArrayList<>();
        for (AdressEntry newEntry : userEntries) {
            if (newEntry.getLastName().equalsIgnoreCase(lastName)) {
                foundEntry.add(newEntry);
            }
        }
        return foundEntry;
    }


}
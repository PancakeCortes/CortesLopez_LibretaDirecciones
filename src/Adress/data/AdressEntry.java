package Adress.data;

/**
 * Esta clase se diseño para recibir las entradas de datos
 */
public class AdressEntry {

    /**
     * Declaración de las variables utilizadas para la recopilación de datos
     */
    private String firstName;

    private String lastName;

    private String street;

    private String city;

    private String state;

    private String cp;

    private String phone;

    private String email;


    /**
     * Constructor de la clase AdressEntry para datos del usuario
     *
     * @param firstName Nombre
     * @param lastName  Apellido
     * @param street    Calle
     * @param city      Ciudad
     * @param state     Estado
     * @param cp        Código postal
     * @param phone     Número de télefono
     * @param email     Correo electrónico
     */
    public AdressEntry(String firstName, String lastName, String street, String city, String state, String cp, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.cp = cp;
        this.phone = phone;
        this.email = email;
    }


    /**
     * Getters y setters de los parámetros utilizados en la entrada de datos
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String streeT) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "︻╦╤─  Nombre: " + firstName + "\n︻╦╤─  Apellido: " + lastName + "\n︻╦╤─  " +
                "Número de Teléfono: " + phone + "\n︻╦╤─  Correo electrónico: " + email +
                "\n︻╦╤─  Estado: " + state + "\n︻╦╤─  Ciudad: " + city +
                "\n︻╦╤─  Calle: " + street + "\n︻╦╤─  Código postal: " + cp + "\n\n\n";
    }

}
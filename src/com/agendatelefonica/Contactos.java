package com.agendatelefonica;

public class Contactos {
    private String nombre;
    private String apellido;
    private String telefono;

    // constructores
    public Contactos() {
    }

    public Contactos(String nombre, String apellido) {
        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
    }

    public Contactos(String nombre, String apellido, String telefono) {
        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
        this.telefono = telefono.trim();
    }

    // Setter and Getter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return  nombre +
                " " + apellido +
                " - " + telefono ;
    }
}

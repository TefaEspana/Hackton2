package com.agendatelefonica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Agenda {
    private List<Contactos> agenda;
    private int tamanoMax;

    // Constructores
    public Agenda() {
        this.agenda = new ArrayList<>();
        tamanoMax=10;
    }

    public Agenda(int tamanoMax) {
        this.agenda = new ArrayList<>();
        this.tamanoMax = tamanoMax;
    }

    // Getter and Setter

    public List<Contactos> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<Contactos> agenda) {
        this.agenda = agenda;
    }

    public int getTamanoMax() {
        return tamanoMax;
    }

    public void setTamanoMax(int tamanoMax) {
        this.tamanoMax = tamanoMax;
    }

    // METODOS
    public boolean anadirContacto(Contactos nuevoContacto) {
        if (agenda.size() >= tamanoMax) {
            System.out.println("Agenda llena, no se pueden añadir más contactos");
            return false;
        }

        for (Contactos c : agenda) {
            if (c.getNombre().equalsIgnoreCase(nuevoContacto.getNombre()) &&
                    c.getApellido().equalsIgnoreCase(nuevoContacto.getApellido())) {
                System.out.println("El contacto ya existe");
                return false;
            }
        }

        agenda.add(nuevoContacto);
        System.out.println("Contacto añadido correctamente\n");
        return true;
    }
    public boolean existeContacto(Contactos nuevoContacto) {
        for (Contactos c : agenda) {
            if (c.getNombre().equalsIgnoreCase(nuevoContacto.getNombre()) &&
                    c.getApellido().equalsIgnoreCase(nuevoContacto.getApellido())) {
                System.out.println("El contacto ya existe");
                return true;
            }
        }
        System.out.println("El contacto no existe");
        return false;

    }

    @Override
    public String toString(){
        if(agenda.isEmpty()){
            return "La lista se encuentra vacia";
        }

        List<Contactos> ordenados = new ArrayList<>(agenda);
        ordenados.sort(Comparator.comparing(Contactos::getNombre)
                .thenComparing(Contactos::getApellido));

        StringBuilder listaContactos = new StringBuilder("Lista de contactos \n");
        int contadorContacto = 1;
        for(Contactos contacto : ordenados){
            listaContactos.append(contadorContacto).append(". ").append(contacto).append("\n");
            contadorContacto++;
        }

        return listaContactos.toString();
    }
    public String buscaContacto(String nombreCompleto){//String nombre
        for(Contactos contacto : agenda){
            String nombreYApellido = contacto.getNombre()+" "+contacto.getApellido();
            if (nombreYApellido.equalsIgnoreCase(nombreCompleto)){
                System.out.println("El telefono es: "+contacto.getTelefono());
                return contacto.getTelefono();// Termina el metodo si lo encuentra
            }
        }
        System.out.println("No se encontró el contacto.");
        return "No se encontro el contacto";
    }
    public boolean eliminarContacto(Contactos contactoC){//Contacto c
        for(Contactos contacto : agenda){
            if (Objects.equals(contacto.getNombre(), contactoC.getNombre()) && Objects.equals(contacto.getApellido(), contactoC.getApellido())){
                agenda.remove(contacto);
                System.out.println("Contacto: "+contacto.getNombre()+" "+contacto.getApellido()+" Eliminado.");
                return true;
            }
        }
        System.out.println("Contacto no existe.");
        return false;
    }
    public boolean modificarTelefono(String nombre, String apellido, String nuevoTelefono){//String nombre, String apellido, String nuevoTelefono

        if (Objects.equals(nombre, "") || Objects.equals(apellido, "") || Objects.equals(nuevoTelefono, "")) {
            System.out.println("El nombre, el apellido y el numero a reemplazar no pueden estar vacíos.");
            return false;
        }

        for(Contactos contactoModificar : agenda){
            if (contactoModificar.getNombre().equalsIgnoreCase(nombre) &&
                    contactoModificar.getApellido().equalsIgnoreCase(apellido)) {
                    contactoModificar.setTelefono(nuevoTelefono);
                    return true;
            }
        }
        System.out.printf("El contacto %s %s no se encuentra en tu lista actual de contactos\n",nombre,apellido);
        return false;
    }
    public boolean agendaLlena(){
        if(tamanoMax == agenda.size()){
            System.out.println("Agenda llena");
            return  true;
        }else{
            System.out.println("La agenda aun tiene espacio disponible");
            return false;
        }

    }
    public int espacioLibres(){
        int espacionsLibres = tamanoMax - agenda.size();
        System.out.println("Espacios libres en la agenda: "+espacionsLibres);
        return espacionsLibres;
    }
}

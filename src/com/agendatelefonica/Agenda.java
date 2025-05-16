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
    public void anadirContacto(Contactos contacto){//Conctacto c

    }
    public void existeContacto(){//Conctacto c

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
    public void buscaContacto(String nombreCompleto){//String nombre
        for(Contactos contacto : agenda){
            String nombreYApellido = contacto.getNombre()+" "+contacto.getApellido();
            if (nombreYApellido.equalsIgnoreCase(nombreCompleto)){
                System.out.println("El telefono es: "+contacto.getTelefono());
                return;// Termina el metodo si lo encuentra
            }
        }
        System.out.println("No se encontró el contacto.");
    }
    public void eliminarContacto(String contactoC){//Contacto c
        for(Contactos contacto : agenda){
            String contactoCompleto = contacto.getNombre()+" "+contacto.getApellido()+" "+contacto.getTelefono();
            if (contactoCompleto.equalsIgnoreCase(contactoC)){
                agenda.remove(contacto);
                System.out.println("Contacto: "+contacto.getNombre()+" "+contacto.getApellido()+" Eliminado.");
                return;
            }
        }
        System.out.println("Contacto no existe.");
    }
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono){//String nombre, String apellido, String nuevoTelefono

        if (Objects.equals(nombre, "") || Objects.equals(apellido, "") || Objects.equals(nuevoTelefono, "")) {
            System.out.println("El nombre, el apellido y el numero a reemplazar no pueden estar vacíos.");
            return;
        }

        for(Contactos contactoModificar : agenda){
            if (contactoModificar.getNombre().equalsIgnoreCase(nombre) &&
                    contactoModificar.getApellido().equalsIgnoreCase(apellido)) {
                    contactoModificar.setTelefono(nuevoTelefono);
                    return;
            }
        }
        System.out.printf("El contacto %s %s no se encuentra en tu lista actual de contactos\n",nombre,apellido);
    }
    public void agendaLlena(){
        if(tamanoMax == agenda.size()){
            System.out.println("Agenda llena");
        }

    }
    public void espacioLibres(){
        System.out.println("Espacios libres en la agenda: "+(tamanoMax - agenda.size()));
    }
}

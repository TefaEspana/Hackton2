package com.agendatelefonica;

import java.util.ArrayList;
import java.util.List;

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
        agenda.add(contacto);
    }
    public void existeContacto(){//Conctacto c

    }
    public void listarContactos(){

    }
    public void buscaContacto(){//String nombre

    }
    public void eliminarContacto(){//Contacto c

    }
    public void modificarTelefono(){//String nombre, String apellido, String nuevoTelefono

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

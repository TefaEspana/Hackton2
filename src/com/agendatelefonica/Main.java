package com.agendatelefonica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcionInicio;
        do{
            try{
                System.out.println("---Menu de inicio---");
                System.out.println("Seleccione una de las sigueintes ocpiones");
                System.out.println("1.Iniciar por terminal");
                System.out.println("2.Iniciar por aplicativo visual");
                System.out.println("3.Salir.");
                opcionInicio = scanner.nextInt();
                scanner.nextLine();
                switch (opcionInicio){
                    case 1:
                        menuTerminal();
                        break;
                    case 2:
                        menuVisual();
                        break;
                    case 3:
                        System.out.println("--Hasta una proxima ocasión--");
                        break;
                    default:
                        System.out.println("❌ Opción incorrecta. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida. Debe ingresar un número.");
                scanner.nextLine();
                opcionInicio = 0;
            }
        }while(opcionInicio!=3);
        scanner.close();
    }


    public static void menuTerminal(){
        int opcion;
        Agenda agenda = tamanoAgenda();
        do{
            try{
                System.out.println("---Menu Terminal---");
                System.out.println("Seleccione una de las sigueintes ocpiones");
                System.out.println("1.Añadir contacto");
                System.out.println("2.Buscar existencia de contacto");
                System.out.println("3.Listar contactos");
                System.out.println("4.Buscar contacto");
                System.out.println("5.Eliminar ocntacto");
                System.out.println("6.Modificar Telefono");
                System.out.println("7.Mostar si la agenda esta llena");
                System.out.println("8.Mostar los espacios libres de la agenda");
                System.out.println("9.Salir.");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion){
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:
                        System.out.println(agenda);
                        break;
                    case 4:
                        System.out.println("🔍 Buscar contacto");
                        System.out.print("Ingresa el nombre completo (Nombre Apellido) de contacto que quieres buscar: ");
                        String nombreCompleto = scanner.nextLine().trim();
                        agenda.buscaContacto(nombreCompleto);
                        break;
                    case 5:
                        System.out.println("🗑️ Eliminar contacto");
                        System.out.print("Ingresa el nombre del contacto que quieres eliminar: ");
                        String nombre = scanner.nextLine().trim();
                        System.out.print("Ingresa el apellido del contacto que quieres eliminar: ");
                        String apellido = scanner.nextLine().trim();
                        System.out.print("Ingresa el número de teléfono del contacto que quieres eliminar: ");
                        String telefono = scanner.nextLine().trim();

                        String contactoCompleto = nombre + " " + apellido + " " + telefono;
                        agenda.eliminarContacto(contactoCompleto);
                        break;
                    case 6:
                        System.out.println("Ingrese el nombre del contacto a modificar");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese el apellido del contacto a modificar");
                        String apellido = scanner.nextLine();
                        System.out.println("Ingrese el telefono nuevo a asignar");
                        String telefono = scanner.nextLine();
                        agenda.modificarTelefono(nombre,apellido,telefono);
                        break;
                    case 7:
                        agenda.agendaLlena();
                        break;
                    case 8:
                        agenda.espacioLibres();
                        break;
                    case 9:
                        System.out.println("--Hasta una proxima ocasión--");
                        break;
                    default:
                        System.out.println("❌ Opción incorrecta. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida. Debe ingresar un número.");
                scanner.nextLine();
                opcion = 0;
            }
        }while(opcion!=9);
    }

    public static Agenda tamanoAgenda(){
        Agenda agenda;
        String tamanoAgenda;

        while (true) {
            try {
                System.out.print("Ingrese el tamaño máximo de la agenda (o presione Enter para usar 10): ");
                tamanoAgenda = scanner.nextLine();
                if (tamanoAgenda.isEmpty()) {
                    agenda = new Agenda();
                } else {
                    int tamano = Integer.parseInt(tamanoAgenda);
                    if (tamano <= 0) {
                        System.out.println("❌ El tamaño debe ser mayor que cero.");
                        continue;
                    }
                    agenda = new Agenda(tamano);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Debe ingresar un número entero válido.");
            }
        }
        return agenda;
    }

    public static void menuVisual(){
        System.out.println("Espacio menu visual");
    }
}

package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {

    private Map<String, Contact> data = new HashMap<>();

    public Map<String, Contact> getData() {
        return data;
    }

    public void addContact(Contact contact) {

        data.put(contact.getCode(), contact);
        System.out.println("Contacto añadido: " + contact.getName() + " (" + contact.getCode() + ")\n");

    }

    public void deleteContact(String code) {

        Contact removed = data.remove(code);
        if (removed != null) {
            System.out.println("Contacto eliminado: " + removed.getName() + "\n");
        } else {
            System.out.println("Contacto no encontrado.\n");
        }

    }

    public void showPhonebook() {

        if (data.isEmpty()) {
            System.out.println("Phonebook esta vacio.\n");
        } else {
            for (Contact contact : data.values()) {

                contact.showContactDetails();
                System.out.println("---------------------\n");

            }
        }

    }

    public void showMenu() {

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu Phonebook:\n");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Borrar contacto");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            option = scanner.nextInt();
            System.out.print("\n");
            scanner.nextLine();

            switch (option) {

                case 1:
                    System.out.print("Añada nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Añada apellidos: ");
                    String surnames = scanner.nextLine();
                    System.out.print("Añada número de teléfono: ");
                    String phone = scanner.nextLine();
                    addContact(new Contact(name, surnames, phone));
                    break;

                case 2:
                    showPhonebook();
                    break;

                case 3:
                    System.out.print("Inserte un contacto para borrarlo: ");
                    String code = scanner.nextLine();
                    deleteContact(code);
                    break;

                case 4:
                    System.out.println("Saliendo....\n");
                    break;

                default:
                    System.out.println("Opción no valida, pruebe otra vez.\n");
            }

        } while (option != 4);

    }

}

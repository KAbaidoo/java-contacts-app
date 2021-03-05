package com.kabaidoo.javachallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Contacts> contacts;
    private static Scanner scanner;

    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Welcome to my humble world of programming");
        showInitialOptions();

    }
    private static void showInitialOptions (){
        System.out.println("Please select one:" +
                "\n 1. Manage Contacts" +
                "\n 2. Messages" +
                "\n 3. Quit");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;


        }


        }

    private static void manageMessages() {
        System.out.println("Please select one: "+
                "\n\t1. Show all messages"+
                "\n\t2. Send a new message"+
                "\n\t3. Go Back");

    }

    private static void manageContacts(){
        System.out.println("Please select One:" +
                "\n\t1. Show all contacts"+
                "\n\t2. Add new contact"+
                "\n\t3. Search for a contact"+
                "\n\t4. Delete a contact"+
                "\n\t5. Go Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Please enter contact name:");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("Please enter the name");
            deleteContact();
        } else{
            boolean doesExist = false;
            for (Contacts c: contacts){
                if (c.getName().equals(name)){
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if (!doesExist){
                System.out.println("There is no such contact");
            }
        }
    }

    private static void searchForContact() {
        System.out.println("Please enter the contact's name: ");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("Please enter name");
            searchForContact();
        } else {
            boolean doesExist = false;
            for(Contacts c: contacts){
                if (c.getName().equals(name)){
                    doesExist = true;
                    c.getDetails();
                }

            }
            if (!doesExist){
                System.out.println("There is no such contact");
                
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact..."+
                "\nPlease enter the contact's name: ");
        String name = scanner.next();
        System.out.println("\nPlease enter the contact's number: ");
        String number = scanner.next();
        System.out.println("\nPlease enter the contact's email: ");
        String email = scanner.next();
    if (name.equals("")||number.equals("")||email.equals("")){
        System.out.println("Please enter all of the information");
        addNewContact();
    }else {
        boolean doesExist = false;
        for (Contacts c: contacts){
            if (c.getName().equals(name)){
                doesExist= true;
            }
            if(doesExist){
                System.out.println("There is already a contact with name " + name + " saved on this device");
                addNewContact();
            }else {
                Contacts contact = new Contacts(name,number,email);
                contacts.add(contact);
                System.out.println(name + " added successfully!");
            }
        }
        showInitialOptions();
    }



    }

    private static void showAllContacts() {
        for (Contacts c: contacts){
            c.getDetails();
            System.out.println("***********************");
        }
        showInitialOptions();
    }
}

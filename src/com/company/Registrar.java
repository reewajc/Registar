package com.company;

/*
Author: Ram Chapagai
Date: 0/04/2021
Description: Assignment 6.1 - Student registar application to display student's information sorted by lastname, id, or original order
Company: Bellevue

 */
import java.io.FileNotFoundException;
import java.nio.file.FileSystemNotFoundException;
import java.util.*;

public class Registrar {
    public static void main(String[] args) throws FileSystemNotFoundException, FileNotFoundException {
        //LinkedList to hold the students informations
        LinkedList<Student> studentLinkedList = new LinkedList<>();

        studentLinkedList.add(new Student("Calderon", "Jonathan", 25));
        studentLinkedList.add(new Student("Chapagai", "Ram", 63));
        studentLinkedList.add(new Student("Cutler", "Thane", 22));
        studentLinkedList.add(new Student("Donahue", "Lucas", 63));
        studentLinkedList.add(new Student("Lambert", "Andrew", 82));
        studentLinkedList.add(new Student("Mays", "Anthony", 49));
        studentLinkedList.add(new Student("Moore", "David", 12));
        studentLinkedList.add(new Student("Moore", "ShiQuise", 74));
        studentLinkedList.add(new Student("Peterson", "Chaz", 23));
        studentLinkedList.add(new Student("Schaeffer", "Amy", 31));
        studentLinkedList.add(new Student("Streeter", "Troy", 13));

        //Registar should control whether or not they have finished sorting
        int originalListCount = 0; //Holds count for selection of list in original order
        int lastnamecount = 0; //Holds count for selection of list by lastname
        int idcount = 0; //Holds count for selection of list by id
        int count = 0; //Holds the count for all sorting selected

        while (true){
            if(count >= 3){
                System.out.println("You are done with sorting!");
                break;
            }
            System.out.println("Please use the following command to sort the students: \n " +
                    "Display the list in the original order: 1, \n" +
                    "Display the list order by last name: 2 \n " +
                    "Display the list order by ID: 3");
            System.out.print("Please type in the  selection: ");
            Scanner scanner = new Scanner(System.in);
            int selection = scanner.nextInt();

            //get the uer info and perform the sorting based on input
            switch (selection) {
                case 1:
                    if(originalListCount >= 1){
                        System.out.println();
                        System.out.println("***** You have already displayed the student's list in  original order *****. Please make another selection");
                        continue;
                    }
                    display(studentLinkedList);
                    System.out.println("Your have displayed the list in original order");
                    originalListCount++;
                    break;
                case 2:
                    if(lastnamecount >= 1){
                        System.out.println();
                        System.out.println("***** You have already displayed the list by last name order *****. Please make another selection");
                        continue;
                    }
                    System.out.println("Sorting by last name...");
                    Collections.sort(studentLinkedList, Comparator.comparing(Student::getLastName));
                    display(studentLinkedList);
                    System.out.println("Your have displayed the list by student's loast name");
                    lastnamecount++;
                    break;
                case 3:
                    if(idcount >= 1){
                        System.out.println();
                        System.out.println("***** You have already displayed the list by ID order *****. Please make another selection");
                        continue;
                    }
                    System.out.println("Sorting by id...");
                    Collections.sort(studentLinkedList, Comparator.comparingInt(Student::getId));
                    display(studentLinkedList);
                    System.out.println("Your have displayed the list by student's ID");
                    idcount++;
                    break;
            }
            count++;

        }


        }


    private static void display(LinkedList<Student> studentLinkedList) {
        System.out.println("#######################################################################");

        System.out.println("#Last Name                #" + "First name                " + "#Id        ");
        System.out.println("#######################################################################");
        printList(studentLinkedList);
    }

    private static void printList(LinkedList<Student> linkedList) {
        Iterator<Student> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("**********************************");
    }


}

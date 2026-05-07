/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.library_management_system;

/**
 *
 * @author Mahmoud_3wad
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Library_Management_System {
    
    static class Book {
        int id;
        String name;
        String author;

        Book(int id, String name, String author) {
            this.id = id;
            this.name = name;
            this.author = author;
        }
    }

    static class Borrower {
        String username;
        int phone;
        int bookId;
        String bookName;
        String author;

        Borrower(String username, int phone, int bookId, String bookName, String author) {
            this.username = username;
            this.phone = phone;
            this.bookId = bookId;
            this.bookName = bookName;
            this.author = author;
        }
    }

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Borrower> borrowers = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        welcomeScreen();
        mainMenu();
    }

    // ****************** Welcome Screen ******************
    static void welcomeScreen() {
        System.out.println("\n************************************");
        System.out.println("*  Welcome to the Library Program  *");
        System.out.println("************************************");
        System.out.println("Made by : PIXELS\n-Mahmoud Awad Elsayed\n-Mahmoud Saber Ebrahim\n-Mahmoud Amr Hamdy\n-Mahmoud Amr Abdelmotaleb\n-Mahmoud Salah Bedir\nUnder Supervision: Dr. Noha Sakr\n");
    }

    // ****************** Main Menu ******************
    static void mainMenu() {
        while (true) {
            System.out.println("\n------ Main Menu ------");
            System.out.println("1. Book Menu");
            System.out.println("2. Borrower Menu");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookMenu();
                    break;
                case 2:
                    borrowerMenu();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // ****************** Book Menu ******************
    static void bookMenu() {
        while (true) {
            System.out.println("\n------ Book Menu ------");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Search Book");
            System.out.println("5. Show All Books");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    showAllBooks();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // ****************** Add Book ******************
    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        books.add(new Book(id, name, author));
        System.out.println("Book added successfully!");
    }

    // ****************** Update Book ******************
    static void updateBook() {
        System.out.print("Enter Book ID to Update: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                scanner.nextLine();
                System.out.print("Enter New Book Name: ");
                book.name = scanner.nextLine();
                System.out.print("Enter New Author Name: ");
                book.author = scanner.nextLine();
                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // ****************** Delete Book ******************
    static void deleteBook() {
        System.out.print("Enter Book ID to Delete: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                books.remove(book);
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // ****************** Search Book ******************
    static void searchBook() {
        System.out.print("Enter Book ID to Search: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                System.out.println("Book ID: " + book.id);
                System.out.println("Book Name: " + book.name);
                System.out.println("Author: " + book.author);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // ****************** Show All Books ******************
    static void showAllBooks() {
        System.out.println("\n------ List of All Books ------");
        for (Book book : books) {
            System.out.println("ID: " + book.id + " | Name: " + book.name + " | Author: " + book.author);
        }
    }

    // ****************** Borrower Menu ******************
    static void borrowerMenu() {
        while (true) {
            System.out.println("\n------ Borrower Menu ------");
            System.out.println("1. Add Borrower");
            System.out.println("2. Show All Borrowers");
            System.out.println("3. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBorrower();
                    break;
                case 2:
                    showAllBorrowers();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // ****************** Add Borrower ******************
    static void addBorrower() {
        scanner.nextLine();
        System.out.print("Enter Borrower's Name: ");
        String username = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        int phone = scanner.nextInt();
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book Name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        borrowers.add(new Borrower(username, phone, bookId, bookName, author));
        System.out.println("Borrower added successfully!");
    }

    // ****************** Show All Borrowers ******************
    static void showAllBorrowers() {
        System.out.println("\n------ List of All Borrowers ------");
        for (Borrower borrower : borrowers) {
            System.out.println("Name: " + borrower.username + " | Phone: " + borrower.phone +
                    " | Book ID: " + borrower.bookId + " | Book Name: " + borrower.bookName +
                    " | Author: " + borrower.author);
        }
    }
}
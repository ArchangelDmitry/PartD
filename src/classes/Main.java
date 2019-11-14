package classes;

//1. Дан список книг. Книга содержит название, автора и год издания.
// Необходимо: найти самую старую книгу и вывести ее автора; найти книгу определенного автора и вывести ее название (или названия);
// найти книги, изданные ранее введенного года и вывести всю информацию по ним.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Library
        Book[] books = new Book[5];

        books[0] = new Book();
        books[0].nameBook = "IT";
        books[0].authorBook = "Stephen King";
        books[0].yearBook = 1986;

        books[1] = new Book();
        books[1].nameBook = "The Martian Chronicles";
        books[1].authorBook = "Ray Bradbury";
        books[1].yearBook = 1950;

        books[2] = new Book();
        books[2].nameBook = "Nine Princes in Amber";
        books[2].authorBook = "Roger Zelazny";
        books[2].yearBook = 1970;

        books[3] = new Book();
        books[3].nameBook = "The Alchemist";
        books[3].authorBook = "Howard Lovecraft";
        books[3].yearBook = 1916;

        books[4] = new Book();
        books[4].nameBook = "The Standoff";
        books[4].authorBook = "Chuck Hogan";
        books[4].yearBook = 1995;

        //Entrance to library

        while (true) {
            String oneS = "1. Find the oldest book.";
            String twoS = "2. Find book by a specific author.";
            String threeS = "3. Find books published earlier than the entered year.";
            System.out.println();
            System.out.println("Welcome to Virtual Horror Library!");
            System.out.println("With our functionality you can: ");
            System.out.println();
            System.out.println(oneS);
            System.out.println(twoS);
            System.out.println(threeS);
            System.out.println();

            //Options
            System.out.println("Please, enter value of needed option.(1-3)");

            int value = sc.nextInt();

            //The oldest book
            if (value == 1) {
                System.out.println("You choose option № " + value);
                System.out.println(oneS);

                Book oldest = books[0];

                for (int x = 1; x < books.length; x++) {
                    if (oldest.yearBook > books[x].yearBook) {
                        oldest = books[x];
                    }
                }
                System.out.println();
                System.out.println("The oldest book in our Library is: ");
                System.out.println();
                System.out.println("Book: " + oldest.nameBook);
                System.out.println("Author: " + oldest.authorBook);

                //Books of authors.
            } else if (value == 2) {
                System.out.println("You choose option № " + value);
                System.out.println(twoS);
                System.out.println();
                System.out.println("Our library contains books of next authors: ");
                System.out.println(books[0].authorBook);
                System.out.println(books[1].authorBook);
                System.out.println(books[2].authorBook);
                System.out.println(books[3].authorBook);
                System.out.println(books[4].authorBook);
                System.out.println();
                System.out.println("Please type full name of needed author: ");
                String nameAuthor = sc.nextLine();

                for (Book book : books) {
                    if (book.authorBook.toLowerCase().contains(nameAuthor.toLowerCase())) {

                        System.out.println();
                        System.out.println("Book: " + book.nameBook);
                        System.out.println("Year: " + book.yearBook);
                    }
                }

                //Previously published books
            } else if (value == 3) {
                System.out.println("You choose option № " + value);
                System.out.println(threeS);
                System.out.println();
                System.out.println("Please enter year: ");
                int early = sc.nextInt();

                System.out.println("Books that were published earlier than " + early + " year: ");

                for (Book book : books) {
                    if (book.yearBook < early) {

                        System.out.println();
                        System.out.println("Author: " + book.authorBook);
                        System.out.println("Book: " + book.nameBook);
                        System.out.println("Year: " + book.yearBook);
                    }
                }

            } else {
                System.out.println("You enter incorrect value");
                break;
            }

            System.out.println("Do you want start from beginning? (y/n)");
            Scanner begin = new Scanner(System.in);
            String start = begin.nextLine();
            if (!start.equals("y")) {
                System.out.println("Thank you for visiting.");
                break;
            }
        }
    }
}
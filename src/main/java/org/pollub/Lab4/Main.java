package org.pollub.Lab4;

public class Main {
    public static void main(String[] args) {

        AuthorBuilder author = AuthorBuilder.builder().name("J.D").surname("Salinger").email("jd@mail.com").build();
        BookBuilder book = BookBuilder.builder().author("J.D. Salinger").title("The Catcher in the rye").year(1951).publisher("Little, Brown and Company").build();
        ReaderBuilder reader = ReaderBuilder.builder().username("Valentine").password("Password1234").name("Ewelina").surname("Valentine").email("ewecia.s@gmail.com").build();

        System.out.println(author);
        System.out.println(book);
        System.out.println(reader);


    }
}

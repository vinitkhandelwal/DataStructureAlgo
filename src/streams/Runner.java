package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) {

        Author a1 = new Author("Vinit","Khandelwal",20);
        Author a2 = new Author("Vinit","Khandelwal1",30);
        Author a3 = new Author("Vinit","Khandelwal2",40);
        Author a4 = new Author("Vinit","Khandelwal3",50);
        Author a5 = new Author("Vinit","Khandelwal4",60);
        Author a6 = new Author("Vinit","Khandelwa5",70);

        Book b1 = new Book("book1",a1);
        Book b2 = new Book("book2",a2);
        Book b3 = new Book("book3",a3);
        Book b4 = new Book("book4",a4);
        Book b5 = new Book("book5",a5);
        Book b6 = new Book("book6",a6);

        List<Book> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        list.add(b6);

        System.out.println(list.stream().map(book -> book.author)
                .filter(author -> author.getAge() > 50)
                .map(author -> author.getLastName().toUpperCase())
                .collect(Collectors.toList()));

    }
}

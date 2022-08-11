import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Library library = new Library(4);
        Author author;
        Book book;
        String path = "src/test.txt";
        try(Scanner scanner = new Scanner(new FileInputStream(path))) {
            while (scanner.hasNext()) {
                String[] info = scanner.nextLine().split(" ");
                author = new Author(info[0], info[1]);
                String nameBook = "";
                for (int i = 2; i < info.length -1; i++) {
                    nameBook += info[i] + " ";
                }
                book = new Book(nameBook.trim(), author,Integer.parseInt(info[info.length - 1]));
                library.addBook(book);
            }
        }
        library.printLibrary();
        System.out.println("Количество книг в библиотеке " + library.getAmount());
        System.out.println();
        library.removeBook("Капитанская дочка");
        library.printLibrary();
        System.out.println();
        library.infoBook("Капитанская дочка");
        System.out.println();
        library.infoBook("Мцири");
        library.setPublisherYear("Мцири", 2022);
        library.infoBook("Мцири");
        System.out.println("Количество книг в библиотеке " + library.getAmount());

    }
}
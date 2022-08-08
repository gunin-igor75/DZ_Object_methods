public class Library {
    private Book[] arrayBook;

    private int amount;

    public Library(int size) {
        arrayBook = new Book[size];
    }

    public int getAmount() {
        return amount;
    }
    // Добавление книги

    public void addBook(Book book) {
        for (int i = 0; i < arrayBook.length; i++) {
            if (arrayBook[i] == null) {
                arrayBook[i] = book;
                amount++;
                return;
            }
        }
        arrayBook = allocate(arrayBook);
        addBook(book);
    }
    // Выделение пвмяти (содание нового массива и копирование старого)

    private Book[] allocate(Book[] arrayBook) {
        int newLength = (int) (arrayBook.length * 1.5);
        Book[] tmp = new Book[newLength];
        System.arraycopy(arrayBook, 0, tmp, 0, arrayBook.length);
        return tmp;
    }
    // Удаление книги

    public void removeBook(String nameBook) {
        for (int i = 0; i < arrayBook.length; i++) {
            if (arrayBook[i] != null && nameBook.equals(arrayBook[i].getBookName())) {
                arrayBook[i] = null;
                amount--;
                return;
            }
        }
        System.out.println("В библиотеки нет такой книги");
    }
    // Печать библиотеки

    public void printLibrary() {
        for (Book book : arrayBook) {
            if (book != null) {
                System.out.println(book);
            }
        }
    }
    // Поиск книги

    private Book findBook(Book book) {
        for (Book elem : arrayBook) {
            if (elem != null && elem.equals(book)) {
                return elem;
            }
        }
        return null;
    }
    // Поиск книги по названю

    public void infoBook(String nameBook) {
        for (Book book : arrayBook) {
            if (book != null && nameBook.trim().equalsIgnoreCase(book.getBookName())) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("В библиотеки нет такой книги");
    }
    // Установка нового года рубликации по названию

    public void setPublisherYear(String name, int year) {
        for (Book book : arrayBook) {
            if (book != null && book.getBookName().equals(name)) {
                book.setPublisherYear(year);
            }
        }
    }
}

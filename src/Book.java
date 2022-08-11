public class Book {
    private String bookName;
    private Author author;
    private int publisherYear;


    public Book(String bookName, Author author, int publisherYear) {
        this.bookName = bookName;
        this.publisherYear = publisherYear;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPublisherYear() {
        return publisherYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setPublisherYear(int publisherYear) {
        this.publisherYear = publisherYear;
    }

    @Override
    public String toString() {
        return author + ":" + bookName + ':' + publisherYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        if (this.bookName.equals(book.bookName) &&
                this.author.equals(book.author) &&
                this.publisherYear == book.publisherYear) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        String string = this.author + this.bookName;
        int result = string == null ? 0 : string.hashCode();
        result = 31 * result + this.publisherYear;
        return result;
    }
}

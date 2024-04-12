package fa.training.entities;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class Book extends Publication implements Comparable<Book> {
    private String isbn;

    private Set<String> authors;

    private String publicationPlace;

    public Book() {
        super();
    }

    public Book(Integer publicationYear, String publisher, Date publicationDate, String isbn, Set<String> authors, String publicationPlace) {
        super(publicationYear, publisher, publicationDate);
        this.isbn = isbn;
        this.authors = authors;
        this.publicationPlace = publicationPlace;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", authors=" + authors +
                ", publicationPlace='" + publicationPlace + '\'' +
                ", publicationYear=" + getPublicationYear() +
                ", publisher='" + getPublisher() + '\'' +
                ", publicationDate=" + getPublicationDate() +
                '}';
    }

    @Override
    void display() {
        System.out.println(this.toString());
    }

    @Override
    public int compareTo(Book o) {
        return this.getIsbn().compareTo(o.getIsbn()); // ISBN UNIQUE => NO NEED TO SORT BY PUBLICATION DATE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

package fa.training.services.servicesImpl;

import fa.training.entities.Book;
import fa.training.services.BookService;
import fa.training.utils.Validator;

import java.util.*;


public class BookServiceImpl implements BookService {
    List<Book> books = new ArrayList<>();



    @Override
    public void addBook() {
        System.out.println("=========ADD BOOK=============");

        String publicationYear, publisher, publicationDate, isbn, publicationPlace;
        Set<String> authors = new HashSet<>();

        do {
            System.out.print("Enter publication year: ");
            publicationYear = Validator.sc.nextLine();
            if (!Validator.intValidate(publicationYear)) {
                System.out.println("Publication year is invalid. Please try again.");
            }
        } while (!Validator.intValidate(publicationYear));

        System.out.print("Enter Publisher:");
        publisher = Validator.sc.nextLine();

        do {
            System.out.print("Enter ISBN: ");
            isbn = Validator.sc.nextLine();
            if (!Validator.isbnValidate(isbn, books)) {
                System.out.println("ISBN is invalid. Please try again.");
            }
        } while (!Validator.isbnValidate(isbn, books));

        do {
            System.out.print("Enter date: ");
            publicationDate = Validator.sc.nextLine();
            if (!Validator.isValidDate(publicationDate)) {
                System.out.println("Date is invalid. Please try again.");
            }
        } while (!Validator.isValidDate(publicationDate));
        String tmp;
        do {
            System.out.print("Enter number of authors: ");
            tmp = Validator.sc.nextLine();
            if (!Validator.intValidate(tmp)) {
                System.out.println("The input is in valid. Please try again.");
            }
        } while (!Validator.intValidate(tmp));
        int i = 0;
        while (i < Integer.parseInt(tmp)) {
            System.out.print("Enter author " + (i + 1) + ": ");
            String author = Validator.sc.nextLine();
            if (!authors.contains(author)) {
                authors.add(author);
                i++;
            } else {
                System.out.println("Author already exists");
            }
        }

        System.out.print("Enter Publication Place:");
        publicationPlace = Validator.sc.nextLine();


        Book newBook = new Book(Integer.parseInt(publicationYear), publisher, Validator.parseDate(publicationDate),
                isbn, authors, publicationPlace);
        books.add(newBook);
        System.out.println("Book added successfully");
    }

    @Override
    public void searchBook() {
        System.out.print("Enter search data:");
        String searchData = Validator.sc.nextLine();
        List<Book> searchBooks = books.stream()
                .filter(book -> book.getIsbn().contains(searchData) ||
                        book.getAuthors().stream().anyMatch(author -> author.contains(searchData)) ||
                        book.getPublisher().contains(searchData))
                .sorted(Comparator.comparing(Book::getIsbn))
                .toList();

        if (searchBooks.isEmpty()) {
            System.out.println("No book found");
        } else {
            System.out.println("=========SEARCH RESULT=============");
            for (Book book : searchBooks) {
                System.out.println(book);
            }
        }
    }

    @Override
    public void updateAuthor() {
        System.out.print("Enter ISBN:");
        String isbn = Validator.sc.nextLine();


    }

    @Override
    public void showAll() {
        System.out.println("=========LIST OF BOOKS=============");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

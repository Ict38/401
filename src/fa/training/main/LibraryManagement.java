package fa.training.main;

import fa.training.entities.Book;
import fa.training.services.BookService;
import fa.training.services.servicesImpl.BookServiceImpl;
import fa.training.utils.Validator;

public class LibraryManagement {

    BookService bookService = new BookServiceImpl();

    public static void main(String[] args) {
        LibraryManagement libraryManagement = new LibraryManagement();
        Validator.openScanner();
        while (true) {
            System.out.println("=========LIBRARY MANAGEMENT SYSTEM=========");
            System.out.println("1. Add book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Show book and magazine with same publication year");
            System.out.println("4. Update Book's author");
            System.out.println("5. Display highest volumn magazine");
            System.out.println("6. Search book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = Validator.sc.nextInt();
            Validator.sc.nextLine();

            switch (choice) {
                case 1:
                    libraryManagement.bookService.addBook();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    libraryManagement.bookService.searchBook();
                    break;
                case 7:
                    Validator.closeScanner();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, please re-enter value from 1 to 7".toUpperCase());
            }
        }
    }
}

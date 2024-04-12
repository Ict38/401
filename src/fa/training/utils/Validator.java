package fa.training.utils;

import fa.training.entities.Book;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {

    final static String ISBN_REGEX = "^[\\d\\-]+$";

    final static String DATE_FORMAT = "dd/MM/yyyy";

    public static Scanner sc;

    public static void openScanner() {
        sc = new Scanner(System.in);
    }

    public static void closeScanner() {
        sc.close();
    }

    public static boolean isValidDate(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static Date parseDate(String date) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        df.setLenient(false);
        try {
            return df.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean intValidate(String integer) {
        try {
            int i = Integer.parseInt(integer);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isbnValidate(String isbn,List<Book> books ) {
        if (isbn.length() < 10 || isbn.length() > 17) return false;
        Pattern pattern = Pattern.compile(ISBN_REGEX);
        if (!pattern.matcher(isbn).matches()) return false;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return false;
            }
        }
        return true;
    }
}

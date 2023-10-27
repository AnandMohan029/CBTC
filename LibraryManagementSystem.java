
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public void returnBook(Book book) {
        books.add(book);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a book");
            System.out.println("2. Display available books");
            System.out.println("3. Search for a book");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    Book book = new Book(title, author);
                    library.addBook(book);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.println("Here are all the books in the library:");
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter the title of the book to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.searchBook(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Book found! Title: " + foundBook.getTitle() + ", Author: " + foundBook.getAuthor());
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    boolean isBorrowed = library.borrowBook(borrowTitle);
                    if (isBorrowed) {
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Book not available for borrowing!");
                    }
                    break;
                case 5:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    Book returnBook = library.searchBook(returnTitle);
                    if (returnBook != null) {
                        library.returnBook(returnBook);
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using the library management system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

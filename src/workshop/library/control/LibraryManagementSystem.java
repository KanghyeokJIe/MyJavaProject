package workshop.library.control;

import workshop.library.entity.Book;
import workshop.library.entity.Library;

import java.util.List;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library("중앙 도서관");

        addSampleBooks(library);

        System.out.println("===== " + library.getName() + " =====");
        printLibraryStatus(library);

        System.out.println("\n===== 도서 검색 테스트 =====");
        testFindBook(library);

        System.out.println("\n===== 도서 대출 테스트 =====");
        testCheckOut(library, "978-89-01-14077-4");  // 자바의 정석

        System.out.println("\n===== 도서 반납 테스트 =====");
        testReturn(library, "978-89-01-14077-4");  // 자바의 정석

        System.out.println("===== 대출 가능한 도서 목록 =====");
        displayAvailableBooks(library);
    }

    private static void addSampleBooks(Library library) {
        addBookAndPrint(library, new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        addBookAndPrint(library, new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        addBookAndPrint(library, new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        addBookAndPrint(library, new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        addBookAndPrint(library, new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        addBookAndPrint(library, new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
    }

    private static void addBookAndPrint(Library library, Book book) {
        library.addBook(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    private static void printLibraryStatus(Library library) {
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
    }

    private static void testFindBook(Library library) {
        System.out.println("제목으로 검색 결과:");
        Book foundByTitle = library.findBookByTitle("자바의 정석");
        if (foundByTitle != null) {
            printBookInfo(foundByTitle);
        }

        System.out.println("\n저자로 검색 결과:");
        List<Book> foundByAuthor = library.findBooksByAuthor("Robert C. Martin");
        for (Book book : foundByAuthor) {
            printBookInfo(book);
        }
    }

    private static void testCheckOut(Library library, String isbn) {
        boolean result = library.checkOutBook(isbn);
        if (result) {
            System.out.println("도서 대출 성공!");
            System.out.println("대출된 도서 정보:");
            printBookInfo(library.findBookByISBN(isbn));
        } else {
            System.out.println("도서 대출 실패!");
        }

        System.out.println("\n도서관 현재 상태:");
        printLibraryStatus(library);
    }

    private static void testReturn(Library library, String isbn) {
        boolean result = library.returnBook(isbn);
        if (result) {
            System.out.println("도서 반납 성공!");
            System.out.println("반납된 도서 정보:");
            printBookInfo(library.findBookByISBN(isbn));
        } else {
            System.out.println("도서 반납 실패!");
        }

        System.out.println("\n도서관 현재 상태:");
        printLibraryStatus(library);
    }

    private static void displayAvailableBooks(Library library) {
        List<Book> books = library.getAvailableBooks();
        for (Book book : books) {
            printBookInfo(book);
            System.out.println("------------------------");
        }
    }

    private static void printBookInfo(Book book) {
        System.out.printf("책 제목: %s\t저자: %s\tISBN: %s\t출판년도: %d\t대출 가능 여부: %s%n",
                book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublishYear(),
                book.isAvailable() ? "가능" : "대출 중");
    }
}

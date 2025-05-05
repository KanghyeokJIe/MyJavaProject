package workshop.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // ��� ���� (ĸ��ȭ)
    private String name;
    private List<Book> books;

    // ������
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // ���� �߰�
    public void addBook(Book book) {
        books.add(book);
    }

    // �������� ���� �˻� (ù ��° ��ġ ���� ��ȯ)
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // ���ڷ� ���� �˻� (���� �� ��ȯ)
    public List<Book> findBooksByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                results.add(book);
            }
        }
        return results;
    }

    // ISBN���� ���� �˻� (��Ȯ�� �ϳ� ��ȯ)
    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // ���� ����
    public boolean checkOutBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) {
            return book.checkOut();
        }
        return false;
    }

    // ���� �ݳ�
    public boolean returnBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) {
            book.returnBook();
            return true;
        }
        return false;
    }

    // ���� ������ ���� ��� ��ȯ
    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                available.add(book);
            }
        }
        return available;
    }

    // ��ü ���� ��� ��ȯ
    public List<Book> getAllBooks() {
        return books;
    }

    // �� ���� ��
    public int getTotalBooks() {
        return books.size();
    }

    // ���� ������ ���� ��
    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    // ���� ���� ���� ��
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }

    // ������ �̸� Getter
    public String getName() {
        return name;
    }

    // ������ �̸� Setter
    public void setName(String name) {
        this.name = name;
    }
}

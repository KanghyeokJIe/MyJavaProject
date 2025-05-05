package mylab.book.entity;

public class Novel extends Publication {
    private String author;
    private String genre;

    public Novel(String title, String publishDate, int page, int price, String author, String genre) {
        super(title, publishDate, page, price);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("%s [소설] 저자:%s, 장르:%s, %d쪽, %,d원, 출판일:%s",
            getTitle(), author, genre, getPage(), getPrice(), getPublishDate());
    }
}

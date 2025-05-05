package workshop.music.entity;

public abstract class MusicMedia {
    protected String title;
    protected String artist;

    public MusicMedia(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public abstract void play();

    public void displayInfo() {
        System.out.printf("제목: %s, 아티스트: %s%n", title, artist);
    }
}

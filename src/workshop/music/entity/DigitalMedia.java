package workshop.music.entity;

public class DigitalMedia extends MusicMedia {
    protected String format;

    public DigitalMedia(String title, String artist, String format) {
        super(title, artist);
        this.format = format;
    }

    @Override
    public void play() {
        System.out.printf("%s 형식의 '%s'이(가) 디지털로 재생됩니다.%n", format, title);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("포맷: " + format);
    }
}

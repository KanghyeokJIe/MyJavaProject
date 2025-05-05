package workshop.music.entity;

public class Vinyl extends MusicMedia {
    private int rpm;

    public Vinyl(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }

    @Override
    public void play() {
        System.out.printf("바이닐 레코드 '%s'이(가) %drpm으로 재생됩니다.%n", title, rpm);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("회전 속도: " + rpm + " rpm");
    }

    public void clean() {
        System.out.println("바이닐 레코드를 청소합니다.");
    }
}

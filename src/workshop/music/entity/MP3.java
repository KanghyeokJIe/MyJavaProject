package workshop.music.entity;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize;
    private int volume;

    public MP3(String title, String artist, int fileSize) {
        super(title, artist, "MP3");
        this.fileSize = fileSize;
        this.volume = 5;
    }

    @Override
    public void play() {
        super.play();
        System.out.println("현재 볼륨: " + volume);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("파일 크기: " + fileSize + "MB");
    }

    @Override
    public void setVolume(int level) {
        this.volume = level;
        System.out.println("볼륨이 " + volume + "로 설정되었습니다.");
    }

    @Override
    public void stop() {
        System.out.println("MP3 재생이 중지되었습니다.");
    }
}

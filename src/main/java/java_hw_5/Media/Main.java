package java_hw_5.Media;

public class Main {
    public static void main(String[] args) {
        Media media = new Media("S&M", 3);
        Music song = new Music("S&M", 3, "Rihanna");
        Video video = new Video("AUT Java Bilyi G51", 3, "1920x1080");
        System.out.println(media.play());
        System.out.println(song.play());
        System.out.println(video.play());
    }
}

package java_hw_5.Media;

public class Media {
    private String title;
    private int duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String play(){
        return "Multimedia playback";
    }

    public Media(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Media{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}

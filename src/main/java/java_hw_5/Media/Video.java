package java_hw_5.Media;

public class Video extends Media{
    private String resolution;

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Video(String title, int duration, String resolution) {
        super(title, duration);
        this.resolution = resolution;
    }

    @Override
    public String play() {
        return "Video \""+super.getTitle()+"\" is playing with resolution "+this.resolution;
    }

    @Override
    public String toString() {
        return "Video{" +
                "resolution='" + resolution + '\'' +
                '}';
    }
}

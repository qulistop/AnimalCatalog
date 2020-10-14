package ord.aplas.animalcatalog;

public class DataItem {

    private String title;
    private String info;
    private String youtube;
    private int icon;
    private int video;

    public DataItem(String mTitle, String mInfo, int mIcon, String mYoutube, int mVideo) {
        title = mTitle;
        info = mInfo;
        icon = mIcon;
        youtube = mYoutube;
        video = mVideo;
    }

    public String getTitle() {
        return title;
    }
    public String getInfo() {
        return info;
    }
    public String getYoutube() {
        return youtube;
    }
    public int getIcon() {
        return icon;
    }
    public int getVideo() {
        return video;
    }

    public void setTitle(String val) {
        this.title =val;
    }
    public void setInfo(String val) {
        this.info = val;
    }
    public void setYoutube(String val) {
        this.youtube = val;
    }
    public void setIcon(int val) {
        this.icon = val;
    }
    public void setVideo(int val) {
        this.video = val;
    }
}

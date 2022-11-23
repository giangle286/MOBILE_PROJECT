package nhatro;

public class nhatro {
    private static int resourceId;
    private String title;

    public static int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public nhatro(int resourceId, String title) {
        this.resourceId = resourceId;
        this.title = title;

    }
}

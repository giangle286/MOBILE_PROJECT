package com.example.models;

public class Blog {
    private String TitleBlog;
    private int ImageBlog;
    private String TimeBlog;

    public String getTitleBlog() {
        return TitleBlog;
    }

    public void setTitleBlog(String titleBlog) {
        TitleBlog = titleBlog;
    }

    public String getTimeBlog() {
        return TimeBlog;
    }

    public void setTimeBlog(String timeBlog) {
        TimeBlog = timeBlog;
    }

    public int getImageBlog() {
        return ImageBlog;
    }

    public void setImageBlog(int imageBlog) {
        ImageBlog = imageBlog;
    }

    public Blog(String titleBlog, int imageBlog, String timeBlog) {
        TitleBlog = titleBlog;
        ImageBlog = imageBlog;
        TimeBlog = timeBlog;
    }
}

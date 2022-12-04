package com.example.models;

public class Blog {
    private String TitleBlog;
    private int ImageBlog;

    public String getTitleBlog() {
        return TitleBlog;
    }

    public void setTitleBlog(String titleBlog) {
        TitleBlog = titleBlog;
    }

    public int getImageBlog() {
        return ImageBlog;
    }

    public void setImageBlog(int imageBlog) {
        ImageBlog = imageBlog;
    }

    public Blog(String titleBlog, int imageBlog) {
        TitleBlog = titleBlog;
        ImageBlog = imageBlog;
    }
//    public Blog(String content, int image) {
//        Content = content;
//        Image = image;
//    }
//
//    public String getContent() {
//        return Content;
//    }
//
//    public void setContent(String content) {
//        Content = content;
//    }
//
//    public int getImage() {
//        return Image;
//    }
//
//    public void setImage(int image) {
//        Image = image;
//    }
}
//
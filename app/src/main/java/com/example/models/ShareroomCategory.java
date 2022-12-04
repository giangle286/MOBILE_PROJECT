package com.example.models;


import java.util.List;

public class ShareroomCategory {
    private String nameshareroomCategory;
    private List<Shareroom> shareroom;

    public String getNameshareroomCategory() {
        return nameshareroomCategory;
    }

    public void setNameshareroomCategory(String nameshareroomCategory) {
        this.nameshareroomCategory = nameshareroomCategory;
    }

    public List<Shareroom> getShareroom() {
        return shareroom;
    }

    public void setShareroom(List<Shareroom> shareroom) {
        this.shareroom = shareroom;
    }

    public ShareroomCategory(String nameshareroomCategory, List<Shareroom> shareroom) {
        this.nameshareroomCategory = nameshareroomCategory;
        this.shareroom = shareroom;
    }

}

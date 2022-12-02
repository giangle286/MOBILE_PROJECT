package com.example.models;

import java.util.List;

public class TrohomepageCategory {
    private String nametroCategory;
    private List<Trohomepage> trohomepage;

    public TrohomepageCategory(String nametroCategory, List<Trohomepage> trohomepage) {
        this.nametroCategory = nametroCategory;
        this.trohomepage = trohomepage;
    }

    public String getNametroCategory() {
        return nametroCategory;
    }

    public void setNametroCategory(String nametroCategory) {
        this.nametroCategory = nametroCategory;
    }

    public List<Trohomepage> getTrohomepage() {
        return trohomepage;
    }

    public void setTrohomepage(List<Trohomepage> trohomepage) {
        this.trohomepage = trohomepage;
    }
}

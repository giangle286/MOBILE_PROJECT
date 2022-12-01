package com.example.models;

import java.util.List;

public class DecoCategory {
    private String nameCategory;
    private List<Deco> deco;

    public DecoCategory(String nameCategory, List<Deco> deco) {
        this.nameCategory = nameCategory;
        this.deco = deco;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Deco> getDeco() {
        return deco;
    }

    public void setDeco(List<Deco> deco) {
        this.deco = deco;
    }
}

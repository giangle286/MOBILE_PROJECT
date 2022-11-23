package category;

import java.util.List;

public class category {
    private String nameCategory;
    private List<Nhatro> nhatro;

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Nhatro> getNhatro() {
        return nhatro;
    }

    public void setNhatro(List<Nhatro> nhatro) {
        this.nhatro = nhatro;
    }

    public category(String nameCategory, List<Nhatro> nhatro) {
        this.nameCategory = nameCategory;
        this.nhatro = nhatro;

    }
}

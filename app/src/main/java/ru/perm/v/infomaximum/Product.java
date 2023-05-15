package ru.perm.v.infomaximum;

import java.util.Objects;

public class Product {
    private String grp ="";
    private String type = "";
    private Integer num = 0;
    private Integer weight = 0;

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(grp, product.grp) && Objects.equals(type, product.type) && Objects.equals(num, product.num) && Objects.equals(weight, product.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grp, type, num, weight);
    }
}

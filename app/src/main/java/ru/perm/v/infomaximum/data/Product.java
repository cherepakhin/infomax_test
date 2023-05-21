package ru.perm.v.infomaximum.data;

import java.util.Objects;

public class Product {
    private String grp ="";
    private String type = "";
    private Long num = 0L;
    private Long weight = 0L;

    public Product() {
    }

    public Product(String grp, String type, Long num, Long weight) {
        this.grp = grp;
        this.type = type;
        this.num = num;
        this.weight = weight;
    }

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

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
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

    @Override
    public String toString() {
        return "Product{" +
                "group='" + grp + '\'' +
                ", type='" + type + '\'' +
                ", num=" + num +
                ", weight=" + weight +
                '}';
    }
}

package ru.perm.v.infomaximum;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Stat {
    public Integer getMaxWeight(List<Product> products) {
        return Collections.max(products, Comparator.comparing(p -> p.getWeight())).getWeight();
    }

    public Integer getMinWeight(List<Product> products) {
        return Collections.min(products, Comparator.comparing(p -> p.getWeight())).getWeight();
    }
}

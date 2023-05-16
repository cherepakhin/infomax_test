package ru.perm.v.infomaximum;

import java.util.List;
import java.util.Map;

public interface IStat {
    Integer getMaxWeight(List<Product> products);
    Integer getMinWeight(List<Product> products);
    Map<String, Integer> getSumWegthByGroup(List<Product> products);
    List<Product> getDuplicatesByGrpAndType(List<Product> products);
}
